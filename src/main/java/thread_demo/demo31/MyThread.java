package thread_demo.demo31;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    private AtomicInteger count =  new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(count.incrementAndGet());
        }
    }
}
