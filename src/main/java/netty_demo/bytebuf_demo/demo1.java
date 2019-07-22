package netty_demo.bytebuf_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

/**
 * 派生缓存区
 *      slice() : 数据共享
 *      copy() ：数据不共享，新缓存区有自己独立的数据副本。
 */
public class demo1 {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("abcdefg", CharsetUtil.UTF_8);
        ByteBuf byteBuf1 = byteBuf.duplicate();
        byteBuf1.setByte(0, (byte)'h');

        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println(byteBuf.getByte(0) == byteBuf1.getByte(0));

        ByteBuf byteBuf2 = byteBuf.copy();
        byteBuf2.setByte(0, (byte)'k');
        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println(byteBuf.getByte(0) == byteBuf2.getByte(0));

        System.out.println((byteBuf.slice(1, 2)).toString(CharsetUtil.UTF_8));
    }
}
