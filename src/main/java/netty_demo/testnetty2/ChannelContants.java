package netty_demo.testnetty2;


import io.netty.channel.socket.SocketChannel;

import java.util.concurrent.ConcurrentLinkedQueue;

//存放连接到服务端的channel
public class ChannelContants {

    private static ConcurrentLinkedQueue<SocketChannel> channelLists = new ConcurrentLinkedQueue<>();

    public static void push(SocketChannel socketChannel) {
        channelLists.offer(socketChannel);
    }

    public static void remove(SocketChannel socketChannel) {
        if (channelLists.contains(socketChannel)) {
            channelLists.remove(socketChannel);
        }
    }

    public static ConcurrentLinkedQueue<SocketChannel> getChannelLists() {
        return channelLists;
    }
}
