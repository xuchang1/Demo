package io_demo;

import java.io.*;

public class demo1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        while (true) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new BufferedWriter(new FileWriter(new File("io_demo1.txt"), true));
            writer.write(reader.readLine());
            //TODO
            //添加buffer缓存区，如果不关闭流，write的内容不会发送出去
            reader.close();
            writer.close();
        }
    }
}