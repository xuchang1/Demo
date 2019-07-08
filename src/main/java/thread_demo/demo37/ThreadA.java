package thread_demo.demo37;

public class ThreadA extends Thread {

    private ThreadB b;

    public ThreadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (b) {
            System.out.println("A thread name : " + Thread.currentThread().getName() + " begin at " + System.currentTimeMillis());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("A thread name : " + Thread.currentThread().getName() + " end at " + System.currentTimeMillis());
        }
    }
}
