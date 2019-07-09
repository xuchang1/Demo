package thread_demo.demo38;

/**
 * ThreadLocal : 属于线程的局部变量。不用在线程内部声明，能访问到即可。在线程中get的值，即为之前在该线程中声明的值或初始化的值。
 *
 * void set(T value)
 * T get()
 * 只能存储获取一个值。
 */
public class Run {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.start();

        ThreadB threadB = new ThreadB();
        threadB.start();

        for (int i = 0; i < 20; i++) {
            Tools.t.set("Main" + (i + 1));
            System.out.println("Main thread name :" + Thread.currentThread().getName() + Tools.t.get());
        }

    }
}
