package thread_demo.demo37;

/**
 * 通过join源码，理解程序的运行顺序
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        ThreadA a = new ThreadA(b);

        a.start();
        b.start();

        b.join(2000);
        System.out.println("main end at " + System.currentTimeMillis());
    }
}
