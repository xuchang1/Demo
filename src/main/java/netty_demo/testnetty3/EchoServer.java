package netty_demo.testnetty3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        int port =  8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        new EchoServer(port).start();
    }

    private void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            System.out.println("The Echo Server start in : " + port);

            channelFuture.channel().closeFuture().sync();

        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
