package netty_demo.encoder_demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    int i;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead0方法被调用");
        if (msg instanceof String) {
            System.out.println("server receive mag : " + msg.toString());
        }

        ctx.writeAndFlush("efg");
    }
}
