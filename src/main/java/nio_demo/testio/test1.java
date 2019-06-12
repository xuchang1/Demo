package nio_demo.testio;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        // 读一个整数s
        int temp = sca.nextInt();
        System.out.println(temp);
        //读取浮点数
        float flo=sca.nextFloat();
        System.out.println(flo);
        //读取字符
        //...等等的，都是一些太基础的，就不师范了。
    }
}
