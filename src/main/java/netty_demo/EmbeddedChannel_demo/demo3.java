package netty_demo.EmbeddedChannel_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *EmbeddedChannel 测试handler过程中的异常
 */
public class demo3 {
    @Test
    public void test() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }

        ByteBuf buf1 = buf.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FrameChunkDecoder(3));

        assertTrue(channel.writeInbound(buf1.readBytes(2)));

        try {
            channel.writeInbound(buf1.readBytes(4));
            Assert.fail();
        } catch (TooLongFrameException e) {
            System.out.println("抛出TooLongFrameException异常");
            //expected exception
            //如果channel.writeInbound(buf1.readBytes(4))没抛出该异常，则Assert.fail()会抛出异常
        }

        assertTrue(channel.writeInbound(buf1.readBytes(3)));
        assertTrue(channel.finish());

        ByteBuf read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(2), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buf.skipBytes(4).readSlice(3), read);
        read.release();

        buf.release();
    }

    class  FrameChunkDecoder extends ByteToMessageDecoder {

        private final int maxFrameSize;

        public FrameChunkDecoder(int maxFrameSize) {
            this.maxFrameSize = maxFrameSize;
        }

        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            int readableBytes = in.readableBytes();
            if (readableBytes > maxFrameSize) {
                in.clear();
                throw new TooLongFrameException();
            }
            ByteBuf buf = in.readBytes(readableBytes);
            out.add(buf);
        }
    }

}
