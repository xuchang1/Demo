package thread_demo.demo20;

/**
 * 多线程访问同一对象方法，synchronized的地方同步访问，不在synchronized中的代码异步访问
 */
public class Task {
    public void doLongTimeTask() {
        for (int i = 0; i < 20; i++) {
            System.out.println("no synchronized thread name : " + Thread.currentThread().getName() + ", i = " + (i + 1));
        }

        System.out.println();

        synchronized (this) {
            for (int i = 0; i < 20; i++) {
                System.out.println("synchronized thread name : " + Thread.currentThread().getName() + ", i = " + (i + 1));
            }
        }
    }
}
