package testnio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class demo1 {
    public static void main(String[] args) throws IOException {
        try {
            //通过FileInputStream、FileOutputStream获取响应的channel对象
            FileInputStream fileInputStream = new FileInputStream("D:\\Workspace\\Study\\test\\testnio\\test.txt");
            FileChannel channel = fileInputStream.getChannel();

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\Workspace\\Study\\test\\testnio\\test1.txt");
            FileChannel channel1 = fileOutputStream.getChannel();

            //初始化缓存区
            ByteBuffer buffer = ByteBuffer.allocate(20);
            System.out.println("通道文件的大小 : " + channel.size());
            System.out.println("缓存区初始化当前位置 : " + buffer.position());
            System.out.println("缓存区初始化时可写限制 : " + buffer.limit());

            //判断通道内数据是否读取完成
            while (-1 != (channel.read(buffer))){
                System.out.println("缓存区写模式下当前位置 : " + buffer.position());
                System.out.println("缓存区写模式下限制 : " + buffer.limit());

                //从写模式，切换到读模式
                buffer.flip();
                System.out.println("缓存区读模式下当前位置 : " + buffer.position());
                System.out.println("缓存区读模式下限制 : " + buffer.limit());

//                第二次循环时，读取数据报错，IndexOutOfBoundsException，但是该位置是存储数据的，clear并不清空缓存区数据
//                System.out.println("第10位数据 : " + (buffer.get(9)));

                //判断缓存区中，是否还有数据可读取
                while (buffer.hasRemaining()){
                    channel1.write(buffer);
                }

                buffer.clear();
            }

            channel.close();
            channel1.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
