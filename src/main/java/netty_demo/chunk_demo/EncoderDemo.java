package netty_demo.chunk_demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.CharsetUtil;

public class EncoderDemo extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof ByteBuf) {
            System.out.println("写出的消息为 : " + ((ByteBuf) msg).toString(CharsetUtil.UTF_8));
        }
        super.write(ctx, msg, promise);
    }
}
