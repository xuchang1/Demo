package nio_demo.testnio2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverChannel;

    private volatile boolean stop;

    public MultiplexerTimeServer(int port) {

        try {
            //调用open方法，打开选择器Selector和ServerSocketChannel
            selector = Selector.open();
            serverChannel = ServerSocketChannel.open();
            //非阻塞channel才能注册到selector上
            serverChannel.configureBlocking(false);
            //服务端通过socket绑定端口号，传输的最大数据为1024字节
            serverChannel.socket().bind(new InetSocketAddress(port), 1024);
            //将ServerSocketChannel注册到selector上，监听是否有client连接，selector轮询时，
            // 如果有client接入，将接入的client channel注册到selector上监听其SelectionKey.OP_READ
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port ： " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.stop = true;
    }

    @Override
    public void run() {

        while (!stop) {
            try {
                //阻塞的，超过阻塞时间或者有一个channel关心的事件准备就绪了，程序往下运行
                //返回从上一次选择操作到现在的已选择键集
                selector.select();
//                selector.select(10000);
                System.out.println("当前selector上注册的channel : " + selector.keys().size() + ", 当前时间 : " + new Date(System.currentTimeMillis()));
                //返回选择器的已选择键集
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    //从已选择键集中移除
                    //就绪一次，处理一次，处理完成，从已选择键集中移除
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (key != null) {
                            //取消此键的channel到其选择器上的注册
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

        //判断此键是否是有效的
        if (key.isValid()) {
            //判断此键的通道是否已经准备好接受新的套接字连接了
            if (key.isAcceptable()) {
                ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                SocketChannel channel = serverChannel.accept();
                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_READ);
            }

            //判断此建的通道是否已准备好进行读取
            //会报错远程服务器已关闭连接，原因是client接收到数据后就closed掉了channel，此时进行数据读取时报该错误
            if (key.isReadable()) {
                //从channel中读取数据流程 : 将channel中数据读取到缓存区中，再将缓存区中数据读取到字节数组中
                SocketChannel channel = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1204);
                int readBytes = channel.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    //remaining() : limit - position;
                    byte[] bytes = new byte[readBuffer.remaining()];
                    //将缓存区中的数据，传递给目标数组
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order : " + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "Bad Order";
                    doWrite(channel, currentTime);
                } else if (readBytes < 0) {
                    key.cancel();
                    channel.close();
                } else {
                    //读到0字节，忽略
                }

            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        if ((response != null) && (response.trim().length() > 0)) {
            //往channel中写数据的流程 : 将数据转化为byte array，再将byte array添加到缓存区中，再将缓存器write到channel中
            byte[] bytes = response.getBytes();
            ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            channel.write(byteBuffer);
        }
    }
}
