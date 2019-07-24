package netty_demo.nettytimeout;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if (evt instanceof IdleStateEvent) {
            ctx.writeAndFlush(Unpooled.copiedBuffer("是否断开连接了", CharsetUtil.UTF_8))
                    .addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        }

        /*if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            String eventType = null;

            switch (event.state()) {
                case READER_IDLE:
                    eventType = "读超时";
                    break;

                case WRITER_IDLE:
                    eventType = "写超时";
                    break;

                case ALL_IDLE:
                    eventType = "读写超时";
                    break;
            }

            System.out.println(ctx.channel().remoteAddress() + " 超时时间 : " + eventType);
        }*/
    }
}
