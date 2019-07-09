package thread_demo.demo45;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private volatile int nextOpreate = 1;

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();

    private Condition condition2 = lock.newCondition();

    private Condition condition3 = lock.newCondition();

    public void menthod1() {
        try {
            lock.lock();
            if (nextOpreate != 1)
                condition1.await();

            System.out.println("执行method1方法");
            Thread.sleep(1000);
            nextOpreate = 2;
            condition2.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void menthod2() {
        try {
            lock.lock();
            if (nextOpreate != 2)
                condition2.await();

            System.out.println("执行method2方法");
            Thread.sleep(1000);
            nextOpreate = 3;
            condition3.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void menthod3() {
        try {
            lock.lock();
            if (nextOpreate != 3)
                condition3.await();

            System.out.println("执行method3方法");
            Thread.sleep(1000);
            nextOpreate = 1;
            condition1.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
