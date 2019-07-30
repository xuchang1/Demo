package java_demo.demo;

import java.util.Random;

/**
 * 以下的示例中，声明为final的a1发送了改变，但是a2一直不变
 *
 *      a1的值是在test对象初始化后生成的，此处的final是对同一个对象来说，值是不可变的（如最后一步的赋值操作是不允许的），
 *          不同对象值可能不同。
 *
 *      a2用static final修饰的，在类被加载的是时候进行初始化，被类的所有对象共享，不可改变，顾对所有对象来说，值是相同的。
 *
 *      一般定义共享常量时，最好使用static final的形式
 */
public class test {
    private static Random random = new Random();
    private final int a1 = random.nextInt();
    private static final int a2 = random.nextInt();

    public static void main(String[] args) {
        test test1 = new test();
        System.out.println(test1.a1);
        System.out.println(test1.a2);

        test test2 = new test();
        System.out.println(test2.a1);
        System.out.println(test2.a2);

//        test1.a1 = 3;
    }
}
