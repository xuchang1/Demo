package nio_demo.demo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(new InetSocketAddress("127.0.0.1", 8081));

        channel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                if (key.isConnectable()) {
                    if (channel.isConnectionPending()) {
                        if (channel.finishConnect()) {
                            channel.write(ByteBuffer.wrap("1234".getBytes()));
                            System.out.println(System.currentTimeMillis() + "发送数据 : 1234");
                            Thread.sleep(5000);
                            System.out.println(System.currentTimeMillis() + "发送数据 : 5678");
                            channel.write(ByteBuffer.wrap("5678".getBytes()));
                        }
                    } else {
                        channel.connect(new InetSocketAddress("127.0.0.1", 8081));
                    }
                }

            }
        }

    }
}
