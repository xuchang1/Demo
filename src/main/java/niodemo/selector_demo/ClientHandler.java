package niodemo.selector_demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ClientHandler implements Runnable{

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

                    handler(key);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handler(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isConnectable()) {
                SocketChannel channel = (SocketChannel) key.channel();
                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_READ);

                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String body = null;
                while ((body = reader.readLine()) != null) {
                    System.out.println("输入内容 : " + body);
                    channel.write(ByteBuffer.wrap(body.getBytes()));
                }
            } else if (key.isReadable()) {
                SocketChannel channel = (SocketChannel) key.channel();
            }
        }
    }
}
