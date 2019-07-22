package netty_demo.bytebuf_demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class demo2 {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("abc你们", CharsetUtil.UTF_8);
//        System.out.println(byteBuf.readableBytes());
        /*for (int i = 0; byteBuf.readableBytes() > 0; i++) {
              System.out.println(byteBuf.readByte());
        }*/

        for (int i = 0; byteBuf.readableBytes() > 0; i++) {
            System.out.println(byteBuf.readByte());
            System.out.println(byteBuf.getUnsignedByte(i));
        }
//        System.out.println(byteBuf.getByte(0));
//        System.out.println(byteBuf.getUnsignedByte(0));
    }
}
