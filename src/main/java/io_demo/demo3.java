package io_demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//加载resources中的资源
public class demo3 {
    public void init() {
        //直接getClass方法不加/，获得的是当前加载出的class文件的相对位置
//        InputStream inputStream = this.getClass().getResourceAsStream("demo3.properties");
        //getClass方法加/,表示的是获取根目录，后面加绝对路径
//        InputStream inputStream = this.getClass().getResourceAsStream("/io_demo/demo3.properties");
        //getClass().getClassLoader()获取的是 根目录/，所以相对于上个方法，路径开头的地方不用加/
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("io_demo/demo3.properties");
        Properties p = new Properties();

        try {
            p.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(p.get("host"));
        System.out.println(p.get("port"));
    }
}
