package java_demo.num_demo;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Random;

public class numDemo {

    /**
     * 数字格式化
     */
    @Test
    public void test1() {
        simgleFormat("###,###.###", 123456.789);
        simgleFormat("###.##", 123456.789);
    }

    static void simgleFormat(String pattern, double value) {
        //数字格式化类
//        DecimalFormat myFormat = new DecimalFormat(pattern);
        DecimalFormat myFormat = new DecimalFormat();
        myFormat.applyPattern(pattern);
        String output = myFormat.format(value);
        System.out.println(value + " " + pattern + " " + output);
    }

    /**
     * 随机数
     */
    @Test
    public void test2() {
        //Math.random() : 大于等于0小于1的一个double类型随机数
        System.out.println(Math.random());
        System.out.println(getInt(10, 1));
        System.out.println(getChar('b', 'd'));
    }

    //产生一个n-m之间的随机数()
    static int getInt(int n, int m) {
        return (int) (n + Math.random()*(m - n));
    }

    //产生一个a-z之间的随机字符
    static char getChar(char cha1, char cha2) {
        return (char)(cha2 +  (Math.random()*(cha1 - cha2 + 1)));
    }

    @Test
    public void test3() {
        System.out.println(getInt2());;
    }

    static int getInt2() {
        Random random = new Random();
//        return random.nextInt();
        return random.nextInt(10);
    }
}
