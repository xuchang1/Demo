package thread_demo.demo32;

/**
 * 原子类只能保证操作的原子性，不能保证其有序性。
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(service);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
