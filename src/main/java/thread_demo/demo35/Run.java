package thread_demo.demo35;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产消费者模式
 *      多生产者与多消费者，可能会出现假死，所有线程都进入wait()状态。可使用notifyAll()进行唤醒，解决假死问题。
 */
public class Run {
    public static void main(String[] args) {
        Object lock = new Object();
        List list = new ArrayList<>();

        Thread[] threads1 = new Thread[5];
        Thread[] threads2 = new Thread[5];

        for (int i = 0; i < threads1.length; i++) {
            threads1[i] = new ThreadA(lock, list);
        }

        for (int i = 0; i < threads2.length; i++) {
            threads2[i] = new ThreadB(lock, list);
        }

        for (int i = 0; i < threads1.length; i++) {
            threads1[i].start();
        }

        for (int i = 0; i < threads2.length; i++) {
            threads2[i].start();
        }
    }
}
