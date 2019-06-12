package netty_demo.testnetty2;

import com.alibaba.fastjson.JSONObject;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

public class EchoClient {

    private String host;

    private int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    });

            ChannelFuture channelFuture = b.connect().sync();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Channel channel = channelFuture.channel();
            JSONObject jsonObject = new JSONObject();
            while (true) {
                jsonObject.put("name", channel.localAddress().toString());
                jsonObject.put("content", reader.readLine());
                channel.writeAndFlush(Unpooled.copiedBuffer(jsonObject.toJSONString(), CharsetUtil.UTF_8));
            }
//            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 8080;
        if (args != null && args.length >0) {
            try {
                host = args[0];
                port = Integer.valueOf(args[1]);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

        new EchoClient(host, port).start();
    }
}
