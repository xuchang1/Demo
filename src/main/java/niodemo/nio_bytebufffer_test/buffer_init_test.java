package niodemo.nio_bytebufffer_test;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class buffer_init_test {
    public static void main(String[] args) {
        //创建buffer的方法有两种，一个是allocate(capacity),一种是wrap(byte[] array)

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(10);

        ByteBuffer byteBuffer2 = ByteBuffer.wrap("你好，我好，大家好".getBytes(Charset.forName("utf-8")));

        System.out.println("wrap方法创建的缓存区，position : " + byteBuffer2.position() + ", limit : " + byteBuffer2.limit() + ", capacity : " + byteBuffer2.capacity());

//        byteBuffer2.put((byte) 1);

        byte[] bytes = new byte[byteBuffer2.remaining()];

        byteBuffer2.get(bytes);

        System.out.println(new String(bytes, Charset.forName("utf-8")));

        System.out.println("wrap方法创建的缓存区，position : " + byteBuffer2.position() + ", limit : " + byteBuffer2.limit() + ", capacity : " + byteBuffer2.capacity());

    }
}
