package netty_demo.testnetty3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    int i;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof ByteBuf) {
            ByteBuf in = (ByteBuf) msg;
            System.out.println("channelRead0方法被调用 : " + ++i);
            if (in.readableBytes() >= 10) {
                System.out.println("server receive msg :");
                while (in.isReadable()) {
                    System.out.println(in.readByte());
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
