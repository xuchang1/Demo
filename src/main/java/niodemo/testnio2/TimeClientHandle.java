package niodemo.testnio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClientHandle implements Runnable {

    private String host;

    private int port;

    private Selector selector;

    private SocketChannel channel;

    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;

        try {
            selector = Selector.open();
            channel = SocketChannel.open();
            channel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!stop) {
            try {
                selector.select(1000);
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (key != null) {
                            key.cancel();
                            if (key.channel() != null) {
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        if (key.isValid()) {
            if (key.isConnectable()) {
                if (sc.finishConnect()) {
                    sc.register(selector, SelectionKey.OP_READ);
                    doWrite(sc);
                } else {
                    System.out.println("连接服务器失败");
                }
            }

            if (key.isReadable()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(byteBuffer);
                if (readBytes > 0) {
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("now is :" + body);
                    this.stop = true;
                } else if (readBytes < 0) {
                    key.cancel();
                    sc.close();
                } else {
                    //读到0字节，不做处理
                }

            }
        }
    }

    private void doConnect() throws IOException {
        //如果连接成功，则将channel注册到selector上监听其读状态，并发送消息给服务器
        if (channel.connect(new InetSocketAddress(host, port))) {
            channel.register(selector, SelectionKey.OP_READ);
            doWrite(channel);
        } else {
            //未连接成功，则将channel注册到selector上监听其连接状态
            channel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel channel) throws IOException {
        byte[] bytes = "QUERY TIME ORDER".getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.flip();
        channel.write(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            System.out.println("send order 2 server succeed.");
        }
    }
}
