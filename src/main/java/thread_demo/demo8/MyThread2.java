package thread_demo.demo8;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("run threadName : " + Thread.currentThread().getName() + " begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run threadName : " + Thread.currentThread().getName() + " end");
    }
}
