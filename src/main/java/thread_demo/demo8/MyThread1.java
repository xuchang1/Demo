package thread_demo.demo8;

/**
 * currentThread()、this.currentThread()和Thread.currentThread()作用是一样的，调用的都是Thread类中的同一个方法
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("run threadName : " + currentThread().getName() + " begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run threadName : " + this.currentThread().getName() + " name");
    }
}
