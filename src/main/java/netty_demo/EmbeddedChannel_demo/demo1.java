package netty_demo.EmbeddedChannel_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.util.ReferenceCountUtil;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * EmbeddedChannel
 *      writeInbound : 将入站消息写到EmbeddedChannel中
 *      readInbound  : 读取EmbeddedChannel中的入站消息，读取的消息会经过添加到EmbeddedChannel中的所有channel处理
 *
 *      由test3可知 : 如果未经过编解码器的处理，那么写几次入站消息，则相应的需要读几次入站消息。并不会产生粘包。
 */
public class demo1 {

    @Test
    public void test11() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }

        /*EmbeddedChannel channel = new EmbeddedChannel();
        channel.writeInbound(buf);
        ByteBuf byteBuf = (ByteBuf) channel.readInbound();
        while (byteBuf.isReadable()) {
            System.out.println(byteBuf.readByte());
        }*/

        //添加handler，读取入站消息时，会讲过入站handler处理
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

        ByteBuf buf1 = buf.duplicate();
        //retain() : 引用计数+1.不然最后buf.release()会报错，why？
        //TODO
        //将入站消息写到EmbeddedChannel中
        assertTrue(channel.writeInbound(buf1.retain()));
        assertTrue(channel.finish());

        //从EmbeddedChannel中读取入站消息，经过解码器处理的每个消息，为list数组中的每个元素
        //写入了9个字节，经过解码器解析，能读取到3个入站消息
        ByteBuf read = channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        read = channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        read = channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        assertNull(channel.readInbound());
        buf.release();
    }

    @Test
    public void test2() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }

        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

        ByteBuf buf1 = buf.duplicate();

        assertFalse(channel.writeInbound(buf1.readBytes(2)));
        assertTrue(channel.writeInbound(buf1.readBytes(7)));
        assertTrue(channel.finish());

        ByteBuf read = channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        read = channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        read = channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        assertNull(channel.readInbound());
        buf.release();
    }

    @Test
    public void test3() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }

        EmbeddedChannel channel = new EmbeddedChannel();
        ByteBuf buf1 = buf.duplicate();

        channel.writeInbound(buf1.readBytes(4));
        channel.writeInbound(buf1.readBytes(5));
//        channel.finish();

        assertEquals(channel.readInbound(), buf.readSlice(4));
        assertEquals(channel.readInbound(), buf.readSlice(5));
        assertNull(channel.readInbound());
        buf.release();
    }
}
