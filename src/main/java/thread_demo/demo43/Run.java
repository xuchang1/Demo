package thread_demo.demo43;

/**
 *公平锁与非公平锁 :
 *      公平锁 : 线程获取锁的顺序是按照线程加载锁的顺序来的(FIFO的顺序)
 *      非公平锁 : 线程获取锁的顺序是随机的，和线程加载锁的顺序没有关系
 *
 * new ReentrantLock(true) : 公平锁； new ReentrantLock(false) : 非公平锁
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {

        final MyService service = new MyService(true);
        //TODO
        //好像都是公平锁，为什么没有效果？
//        final MyService service = new MyService(false);

        Thread[] threads = new Thread[40];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(service);
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    service.method2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Thread.sleep(100);

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            Thread.sleep(100);
        }
    }

}
