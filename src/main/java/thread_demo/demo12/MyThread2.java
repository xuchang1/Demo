package thread_demo.demo12;

import java.util.Random;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        int count = 0;

        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            Random random = new Random();
            count += random.nextInt();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("线程 " + Thread.currentThread().getName() + " 耗时 : " + (endTime - beginTime) + "秒");
    }
}
