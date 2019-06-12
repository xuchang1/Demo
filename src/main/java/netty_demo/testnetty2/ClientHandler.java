package netty_demo.testnetty2;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println(msg.toString(CharsetUtil.UTF_8));
    }

    /*@Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //while true 能一直输入消息，但是服务端返回消息打印不出来
//        while (true) {
            //system.in会一直阻塞，导致其他事件消息无法打印
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder msg = new StringBuilder();
            String  body = null;
            if ((body = reader.readLine()) != null) {
                msg.append(body);
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", ctx.channel().localAddress().toString());
            jsonObject.put("content", msg.toString());
            ctx.writeAndFlush(Unpooled.copiedBuffer(jsonObject.toJSONString(), CharsetUtil.UTF_8));
//        }
    }*/

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


}
