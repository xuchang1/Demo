package thread_demo.demo35;

import java.util.List;

public class ThreadB extends Thread {

    private Object lock;

    private List list;

    public ThreadB(Object lock, List list) {
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    while (list.size() == 0) {
                        lock.wait();
                    }

                    System.out.println(Thread.currentThread().getName() + " 进行消费");
                    list.remove(0);
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
