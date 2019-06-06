package niodemo.selector_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientHandler implements Runnable {

    private String host;

    private int port;

    private SocketChannel channel;

    private Selector selector;

    public ClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            channel = SocketChannel.open();
            selector = Selector.open();

            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_CONNECT);

            channel.connect(new InetSocketAddress(host, port));

            while (true) {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                if (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    try {
                        handler(key);
                    } catch (Exception e) {
                        if (key != null) {
                            key.cancel();
                        }

                        if (key.channel() != null) {
                            key.channel().close();
                        }

                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handler(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isConnectable()) {
                SocketChannel channel = (SocketChannel) key.channel();
                if (channel.isConnectionPending()) {
                    channel.finishConnect();
                }

                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_READ);

                channel.write(ByteBuffer.wrap(("连接远程服务器").getBytes()));
                //启动线程，进行聊天输入
                new Thread(new say(channel)).start();
            } else if (key.isReadable()) {
                SocketChannel channel = (SocketChannel) key.channel();

                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                channel.read(byteBuffer);

                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.limit()];
                byteBuffer.get(bytes);

                System.out.println(new String(bytes));
            }
        }
    }
}
