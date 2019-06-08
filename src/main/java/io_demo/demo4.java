package io_demo;

import java.io.File;
import java.io.FileInputStream;

/**
 * inputStream的read方法。将返回的字节转会为int类型
 */
public class demo4 {
    public void init() throws Exception {
        File file = new File(this.getClass().getResource("demo4.txt").getPath());
        FileInputStream inputStream = new FileInputStream(file);
        //read方法
        /*int body = 0;
        while ((body = inputStream.read()) != -1) {
            System.out.println(body);
        }*/

        byte[] bytes = new byte[3];
        int length = 0;
        while ((length = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes));
        }
    }
}
