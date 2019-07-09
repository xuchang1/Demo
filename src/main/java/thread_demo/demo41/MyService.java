package thread_demo.demo41;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("thread name : " + Thread.currentThread().getName() + " 调用 methodA");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println("thread name : " + Thread.currentThread().getName() + " 调用 methodB");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
