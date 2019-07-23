package netty_demo.decode_demo;

import io.netty.buffer.Unpooled;
import io.netty.channel.*;

public class EchoServerHandler extends SimpleChannelInboundHandler<Integer> {
    int i;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Integer msg) throws Exception {
        System.out.println("server receive mag : " + msg + ", channelRead0方法被调用 : " + ++i + "次");
        ctx.writeAndFlush(Unpooled.copiedBuffer(new byte[]{(byte) ((int) i)}));
    }
}
