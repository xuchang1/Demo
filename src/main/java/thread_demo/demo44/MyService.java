package thread_demo.demo44;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();

    public void method() {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)){
                System.out.println("thread name : " + Thread.currentThread().getName() + " 获得此锁, at " + System.currentTimeMillis());
                Thread.sleep(1000);
            } else {
                System.out.println("thread name : " + Thread.currentThread().getName() + " 未获得此锁, at " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("thread name : " + Thread.currentThread().getName() + " 释放此锁, at " + System.currentTimeMillis());
            lock.unlock();
        }
    }
}
