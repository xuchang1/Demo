package thread_demo.demo37;

public class ThreadB extends Thread {
    @Override
    public void run() {
        synchronized (this) {
            System.out.println("B thread name : " + Thread.currentThread().getName() + " begin at " + System.currentTimeMillis());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("B thread name : " + Thread.currentThread().getName() + " end at " + System.currentTimeMillis());
        }
    }
}
