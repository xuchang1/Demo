package nio_file_rw_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class demo {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        FileChannel channel = inputStream.getChannel();        FileChannel channel2 = outputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while ((channel.read(buffer)) != -1) {
            buffer.flip();
            channel2.write(buffer);
            buffer.clear(); //如果将该行注释掉，会发生什么？
        }

        channel.close();
        channel2.close();
    }
}
