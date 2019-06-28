package thread_demo.demo31;

/**
 * AtomicInteger : 原子类，保证以原子的方式更新int值
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(myThread);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
