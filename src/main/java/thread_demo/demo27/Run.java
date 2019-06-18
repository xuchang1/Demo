package thread_demo.demo27;

/**
 * 死锁
 *
 * main方法中，如果不休眠，则不会产生死锁，why？
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        DeadThread deadThread = new DeadThread();

        deadThread.setUsername("a");
        Thread thread1 = new Thread(deadThread);
        thread1.start();

        Thread.sleep(100);

        deadThread.setUsername("b");
        Thread thread2 = new Thread(deadThread);
        thread2.start();
    }
}
