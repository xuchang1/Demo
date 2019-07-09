package thread_demo.demo42;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();

    private Lock lock2 = new ReentrantLock();

    private Condition conditionA = lock.newCondition();

    private Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("awaitA wait begin");
            conditionA.await();
            System.out.println("awaitA wait end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("awaitB wait begin");
            conditionB.await();
            System.out.println("awaitB wait end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalA() {
        try {
            lock.lock();
            //不同lock对象同步的代码中，调用其他lock对象生成的condition进行await、signal方法会报错。
//            lock2.lock();
            System.out.println("signalA signal begin");
            conditionA.signalAll();
            System.out.println("signalA signal end");
        } finally {
            lock.unlock();
//            lock2.unlock();
        }
    }

    public void signalB() {
        try {
            lock.lock();
            System.out.println("signalB signal begin");
            conditionB.signalAll();
            System.out.println("signalB signal end");
        } finally {
            lock.unlock();
        }
    }
}
