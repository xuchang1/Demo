package io_demo;

import java.io.File;

//路径相关测试
public class demo2 {

    public void init() {

        String a = this.getClass().getResource("").toString();
        String b = this.getClass().getResource("/").toString();
        String c = this.getClass().getClassLoader().getResource("").toString();

        System.out.println(this.getClass().getResource(""));
        System.out.println(this.getClass().getResource("/"));
        System.out.println(this.getClass().getClassLoader().getResource(""));

        File file1 = new File(this.getClass().getResource("demo2.txt").getPath());
        System.out.println(file1.exists());
    }
}
