package thread_demo.demo41;

/**
 * ReentrantLock : new出一个对象，调用lock()与unlock()方法，对之间的代码进行同步，使用效果与synchronized一样
 *
 * Lock lock = new ReentrantLock();
 * lock.lock();
 * lock.unlock();
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();

        ThreadA threadA = new ThreadA(service);
        threadA.start();

        ThreadB threadB = new ThreadB(service);
        threadB.start();
    }
}
