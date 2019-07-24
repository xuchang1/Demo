package netty_demo.fileregion_demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;

import java.io.File;
import java.io.FileInputStream;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        File file = new File("D:\\WorkSpace\\netttyDemo\\src\\main\\java" +
                "\\netty_demo\\bigdata_demo\\demo.txt");
        FileInputStream inputStream = new FileInputStream(file);
        DefaultFileRegion fileRegion = new DefaultFileRegion(inputStream.getChannel(), 0, file.length());
        ctx.writeAndFlush(fileRegion).addListener(new ChannelFutureListener() {
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
