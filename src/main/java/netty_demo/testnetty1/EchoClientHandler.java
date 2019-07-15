package netty_demo.testnetty1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import utils.tools;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int a = 1234;
//        byte[] bytes = tools.transferBytes(a);
//        ctx.writeAndFlush(Unpooled.copiedBuffer(bytes);
        ctx.writeAndFlush(Unpooled.copiedBuffer(a + "", CharsetUtil.UTF_8));
        System.out.println("The Echo Client send msg");
    }

    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("The Client receive : " + msg.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
