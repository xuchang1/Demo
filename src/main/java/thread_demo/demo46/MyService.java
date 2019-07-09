package thread_demo.demo46;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyService {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void method1() {
        try {
            lock.readLock().lock();
            System.out.println("调用method1方法");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("method1方法运行结束");
            lock.readLock().unlock();
        }
    }

    public void method2() {
        try {
            lock.readLock().lock();
            System.out.println("调用method2方法");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("method2方法运行结束");
            lock.readLock().unlock();
        }
    }
}
