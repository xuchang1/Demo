package netty_demo.chunk_demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.stream.ChunkedFile;

import java.io.File;
import java.io.FileInputStream;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        File file = new File("D:\\WorkSpace\\netttyDemo\\src\\main\\java\\netty_demo\\chunk_demo\\demo.txt");
        ctx.writeAndFlush(new ChunkedFile(file)).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("写成功");
                } else {
                    System.out.println("写失败");
                }
            }
        });
    }

    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
