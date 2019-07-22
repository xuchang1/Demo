package netty_demo.bytebuf_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import org.junit.jupiter.api.Test;

/**
 * set方法
 */
public class demo4 {
    ByteBuf buf = Unpooled.buffer(10);

    @Test
    public void test1() {
        buf.setByte(0,12);
        System.out.println(buf.getByte(0));
    }

    @Test
    public void test2() {
        buf.setInt(0, 0x12345678);
        buf.writerIndex(9);
        buf.readerIndex(9);
        System.out.println(ByteBufUtil.hexDump(buf));
        System.out.println(buf.getByte(0));
        System.out.println(buf.getInt(0));
    }
}
