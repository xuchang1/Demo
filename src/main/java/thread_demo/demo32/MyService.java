package thread_demo.demo32;

import java.util.concurrent.atomic.AtomicLong;

public class MyService {

    private AtomicLong count = new AtomicLong();

    public void add() {
        System.out.println(Thread.currentThread().getName() + " 加了100之后的值是 : " + count.addAndGet(100));
        System.out.println(count.addAndGet(1));

        /*synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " 加了100之后的值是 : " + count.addAndGet(100));
            System.out.println(count.addAndGet(1));
        }*/
    }
}
