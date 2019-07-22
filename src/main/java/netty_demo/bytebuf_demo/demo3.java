package netty_demo.bytebuf_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;

/**
 * ByteBuf的get方法
 *      getByte(int index) : 获取当前索引处字节
 *      getUnsignedByte(int index) : 给定索引处无符号字节作为short返回(结合test1、2,可知Unsigned方法即get方法的高位补0)
 *      getInt()、getShort()等方法同理.
 */
public class demo3 {
        ByteBuf buf = Unpooled.buffer(10);

        @Test
        public void test1() {
                buf.writeByte(1);
                System.out.println(buf.getByte(0));
                System.out.println(buf.getUnsignedByte(0));
        }

        @Test
        public void test2() {
                buf.writeByte(-1);
                System.out.println(buf.getByte(0));
                System.out.println(buf.getUnsignedByte(0));
                System.out.println(0x00ff);
                System.out.println(ByteBufUtil.hexDump(buf));
        }

        @Test
        public void test3() {
                buf.writeByte(-1);
                System.out.println(buf.getInt(0));
                System.out.println(0xff000000);

                System.out.println(buf.getUnsignedInt(0));
                System.out.println(0xff000000L);
                System.out.println(ByteBufUtil.hexDump(buf));
        }
//        buf.writeByte(-12);
//        System.out.println(buf.readByte());
//        System.out.println(buf.readUnsignedByte());
//        System.out.println(buf.getInt(0));
//        System.out.println(0xf4000000);
//        System.out.println(ByteBufUtil.hexDump(buf));

//        System.out.println(buf.getUnsignedInt(0));
//        System.out.println(0xff000000L);
}
