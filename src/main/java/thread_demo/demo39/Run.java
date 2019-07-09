package thread_demo.demo39;

import java.util.Date;

/**
 * 实现ThreadLocal类并重写initialValue()方法，可以设置该变量的初始化值。
 *      在未set之前，调用get方法，会去调用initialValue()方法初始化值，所以不同的线程，初始化的值可能不同，甚至多次调用值都不同。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.start();

        ThreadB threadB = new ThreadB();
        threadB.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(3000);
            System.out.println("Main thread name : " + Thread.currentThread().getName() + " " + Tools.t.get());
            Tools.t.set(new Date());
        }
    }
}
