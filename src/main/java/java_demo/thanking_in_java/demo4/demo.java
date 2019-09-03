package java_demo.thanking_in_java.demo4;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class demo {

    @Test
    public void test1(){
        for (int i = 1; i < 101; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test2(){
        int temp = 0;
        int randomValue = 0;
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            randomValue = random.nextInt();
            if (i == 0) {
                temp = randomValue;
                continue;
            }

            if (randomValue > temp){
                System.out.println("当前随机值 : " + randomValue + " 大于上一次的随机值 : " + temp);
            } else if (randomValue < temp) {
                System.out.println("当前随机值 : " + randomValue + " 小于上一次的随机值 : " + temp);
            } else {
                System.out.println("当前随机值 : " + randomValue + " 等于上一次的随机值 : " + temp);
            }

            temp = randomValue;
        }
    }
}
