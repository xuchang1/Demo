package thread_demo.demo33;

public class Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait(), thread name : " + Thread.currentThread().getName());
                lock.wait();
                System.out.println("end wait(), thread name : " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void NotifyMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin notify(), thread name : " + Thread.currentThread().getName());
                lock.notify();
                Thread.sleep(5000);
                System.out.println("end notify(), thread name : " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
