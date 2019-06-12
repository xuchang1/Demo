package netty_demo.testnetty2;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.CharsetUtil;

import java.util.Iterator;

public class EchoServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //以json格式，将数据发送到服务端
        JSONObject jsonObject = JSONObject.parseObject(msg);
        String clientName = (String) jsonObject.get("name");
        String content = (String) jsonObject.get("content");

        System.out.println("The Echo Server receive : " + clientName + " msg : " + content);

        Iterator<SocketChannel> iterator = ChannelContants.getChannelLists().iterator();
        while (iterator.hasNext()) {
            SocketChannel socketChannel = iterator.next();
            if (socketChannel == ctx.channel()) {
                socketChannel.writeAndFlush(Unpooled.copiedBuffer("自己 : " + content, CharsetUtil.UTF_8));
            } else {
                socketChannel.writeAndFlush(Unpooled.copiedBuffer(clientName + " say : " + content, CharsetUtil.UTF_8));
            }
        }
    }

    //在channelActive与handlerAdded中处理该事件有和区别
    //TODO
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("The client : " + ctx.channel().remoteAddress() + " connect server");

        //发送上线消息
        Iterator<SocketChannel> iterator = ChannelContants.getChannelLists().iterator();
        while (iterator.hasNext()) {
            SocketChannel socketChannel = iterator.next();
            socketChannel.writeAndFlush(Unpooled.copiedBuffer(ctx.channel().remoteAddress() + "上线了", CharsetUtil.UTF_8));
        }

        //客户端连接时，将相应channel存入到消息队列中
        ChannelContants.push((SocketChannel) ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("The client : " + ctx.channel().remoteAddress() + " disConnect from server");

        //客户端断开连接时，将消息队列中，相应channel删除
        ChannelContants.remove((SocketChannel) ctx.channel());

        //发送离线消息
        Iterator<SocketChannel> iterator = ChannelContants.getChannelLists().iterator();
        while (iterator.hasNext()) {
            SocketChannel socketChannel = iterator.next();
            socketChannel.writeAndFlush(Unpooled.copiedBuffer(ctx.channel().remoteAddress() + " 离线了", CharsetUtil.UTF_8));
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ChannelContants.remove((SocketChannel) ctx.channel());
        cause.printStackTrace();
        ctx.close();
    }

}
