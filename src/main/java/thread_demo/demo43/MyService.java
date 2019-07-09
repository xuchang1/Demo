package thread_demo.demo43;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private ReentrantLock lock;

    public MyService(boolean isFair) {
        this.lock = new ReentrantLock(isFair);
    }

    public void method1() {
        System.out.println("thread name : " + Thread.currentThread().getName() + " 尝试获取锁, at " + System.currentTimeMillis());
        lock.lock();
        System.out.println("thread name : " + Thread.currentThread().getName() + " 获取到了锁");
        lock.unlock();
    }

    public void method2() throws InterruptedException {
        lock.lock();
        Thread.sleep(5000);
        System.out.println("method2 释放锁");
        lock.unlock();
    }
}
