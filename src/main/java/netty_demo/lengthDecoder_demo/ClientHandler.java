package netty_demo.lengthDecoder_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("接收返回消息 : " + msg.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("连接建立成功");
        ByteBuf buf = Unpooled.buffer();
        buf.writeByte(1);
        buf.writeBytes("a".getBytes(CharsetUtil.UTF_8));
        buf.writeByte(2);
        buf.writeBytes("bb".getBytes(CharsetUtil.UTF_8));
        buf.writeByte(3);
        buf.writeBytes("ccc".getBytes(CharsetUtil.UTF_8));
//        ByteBuf byteBuf = Unpooled.copiedBuffer(msg, CharsetUtil.UTF_8);
        ctx.channel().writeAndFlush(buf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


}
