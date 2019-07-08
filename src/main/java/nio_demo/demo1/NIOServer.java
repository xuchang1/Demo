package nio_demo.demo1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用多线程处理轮询出来的key时，同一事件可能被多次轮询，不能直接使用多线程进行处理。
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8081));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            //获取注册的channel
            Set<SelectionKey> keys = selector.selectedKeys();
            //遍历所有的key
            Iterator<SelectionKey> iterator = keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isValid()) {
                    //如果通道上有事件发生
                    if (key.isAcceptable()) {
                        //获取该通道
                        ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = acceptServerSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        System.out.println(System.currentTimeMillis() + " Accept request from : " + socketChannel.getRemoteAddress());
                        //同时将SelectionKey标记为可读，以便读取。
                        SelectionKey readKey = socketChannel.register(selector, SelectionKey.OP_READ);
                        //利用SelectionKey的attache功能绑定Acceptor 如果有事情，触发Acceptor
                        //Processor对象为自定义处理请求的类
                        readKey.attach(new Processor());
                    } else if (key.isReadable()) {
                        System.out.println(((SocketChannel)key.channel()).getRemoteAddress() + "触发读事件");
                        Processor processor = (Processor) key.attachment();
                        processor.process(key);
                    }
                }
            }
        }
    }
}

/**
 * Processor类中设置一个线程池来处理请求，
 * 这样就可以充分利用多线程的优势
 */
class Processor {
    private static final ExecutorService service = Executors.newFixedThreadPool(2);

    public void process(final SelectionKey selectionKey) {
        handler(selectionKey);
        //使用线程池处理socketChannel的读写问题，会导致重复触发读操作的问题，因为在创建线程处理key的过程中，该key值有会被重新轮询出来
        /*service.submit(new Runnable() {
            @Override
            public void run() {
                handler(selectionKey);
            }
        });*/
    }

    public void  handler(SelectionKey key) {
        ByteBuffer buffer = null;
        SocketChannel socketChannel = null;
        try {
            buffer = ByteBuffer.allocate(1024);
            socketChannel = (SocketChannel) key.channel();
            int count = socketChannel.read(buffer);
            if (count < 0) {
                socketChannel.close();
                key.cancel();
                System.out.println("Read ended");
            } else if (count == 0) {
            }
        } catch (IOException e) {
            try {
                socketChannel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            key.cancel();
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + " 接收消息 : " + new String(buffer.array()));
    }
}