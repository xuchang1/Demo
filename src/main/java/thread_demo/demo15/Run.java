package thread_demo.demo15;

/**
 * synchronized修饰的是对象的锁
 * 当多个线程，访问同一对象多个不同的synchronized修饰的方法时，必须等待一个方法调用结束，才会继续调用另一个方法
 *
 * 1、A线程先持有MyObject对象的Lock锁，B线程可以异步的调用MyObject对象中非synchronized方法
 * 2、A线程先持有MyObject对象的Lock锁，B线程如果在这时调用MyObject对象中的synchronized方法(即使是不同的synchronized方法)则需等待，也就是同步
 */
public class Run {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();

        ThreadA threadA = new ThreadA(myObject);
        threadA.setName("A");

        ThreadB threadB = new ThreadB(myObject);
        threadB.setName("B");

        threadA.start();
        threadB.start();
    }
}
