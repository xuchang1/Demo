package thread_demo.demo30;

/**
 * volatile只能保证变量的可见性，并不能保证其原子性,需要通过synchronized来保证操作的原子性
 */
public class Run {
    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
