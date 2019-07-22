package netty_demo.EmbeddedChannel_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * EmbeddedChannel
 *      writeOutbound : 将出站消息写到EmbeddedChannel中
 *      readOutbound  : 从EmbeddedChannel中读取出站消息，读取的消息会经过添加到EmbeddedChannel中出站handler处理
 */
public class demo2 {

    @Test
    public void test1() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeInt(i * -1);
        }

        //为EmbeddedChannel添加出站处理器
        EmbeddedChannel channel = new EmbeddedChannel(new AbsIntegerEncoder());
        //将出站数据写到EmbeddedChannel中
        assertTrue(channel.writeOutbound(buf));
        assertTrue(channel.finish());

        for (int i = 0; i < 9; i++) {
            //读取EmbeddedChannel中的出站数据
            assertEquals(i, channel.readOutbound());
        }

        assertNull(channel.readOutbound());
    }

    class AbsIntegerEncoder extends MessageToMessageEncoder<ByteBuf> {

        @Override
        protected void encode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            while (in.readableBytes() >= 4) {
                int value = Math.abs(in.readInt());
                out.add(value);
            }
        }
    }
}
