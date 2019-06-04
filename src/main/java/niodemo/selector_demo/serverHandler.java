package niodemo.selector_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class serverHandler implements Runnable {

    private int port;

    private ServerSocketChannel serverChannel;

    private Selector selector;


    public serverHandler(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            serverChannel = ServerSocketChannel.open();
            selector = Selector.open();

            serverChannel.socket().bind(new InetSocketAddress(port));
            System.out.println("The Server start in port : " + port);

            serverChannel.configureBlocking(false);
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                if (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    handler(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                handlerClose();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void handlerClose() throws IOException {
        selector.close();
    }

    private void handler(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {

                ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                SocketChannel channel = serverChannel.accept();
                System.out.println("客户端 " + channel.getRemoteAddress() + " 连接进入");

                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_READ);
            } else if (key.isReadable()) {

                SocketChannel channel = (SocketChannel) key.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                while ((channel.read(byteBuffer)) != -1) {

                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bytes);
                    System.out.println("输出内容------------------------------------------------------");
                    System.out.println(new String(bytes));

                    //获取到的内容，重新发送给客户端
                    byteBuffer.rewind();
                    channel.write(byteBuffer);
                    byteBuffer.clear();
                }
            }
        }
    }
}
