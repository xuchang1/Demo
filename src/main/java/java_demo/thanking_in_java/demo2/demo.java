package java_demo.thanking_in_java.demo2;

import org.junit.jupiter.api.Test;

public class demo {

    int a;

    char b;

    @Test
    public void test1(){
        int a = 98;
        System.out.println((char) a);
        demo demo1 = new demo();
        System.out.println(demo1.a);
        System.out.println(demo1.b);
        System.out.println('\u0000');
    }
}
