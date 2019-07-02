package thread_demo.demo34;

import java.util.List;

public class ThreadA extends Thread {

    private Object lock;

    private List list;

    public ThreadA(Object lock, List list) {
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (lock) {
                    while ( list.size() != 0) {
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " 进行生产");
                    list.add(System.currentTimeMillis());
                    lock.notify();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
