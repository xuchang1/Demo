package nio_test;

import java.nio.ByteBuffer;

public class Demo1_ReadOnly {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }

        byteBuffer.clear();

        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();

        byteBuffer.put(0, (byte)20);

        //asReadOnlyBuffer()使得生成的缓存区只能进行读操作，当时缓存区数据与原缓存区数据共享
        // 顾改变之前缓存区数据，只读缓存区中数据会进行相应改变
        System.out.println(readOnlyBuffer.get());
    }
}
