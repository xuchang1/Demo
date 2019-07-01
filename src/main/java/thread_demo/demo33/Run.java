package thread_demo.demo33;

/**
 * Object类的wait()、notify()方法
 *      通过一个对象，调用这些方法之前，必须先获得该对象的对象级别锁，只能在用该对象锁修饰的同步方法或者同步代码块中执行。
 *
 *      wait()执行后，会释放锁。notify()的同步代码执行完后，才会释放锁。唤醒的后续代码会去竞争该锁，执行后续代码。
 */
public class Run {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        threadA.start();

        ThreadB threadB = new ThreadB(lock);
        threadB.start();

        ThreadC threadC = new ThreadC(lock);
        threadC.start();
    }
}
