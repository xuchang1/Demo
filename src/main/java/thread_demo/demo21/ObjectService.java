package thread_demo.demo21;

public class ObjectService {
    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("thread name : " + Thread.currentThread().getName() + ". A begin time : " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("thread name : " + Thread.currentThread().getName() + ",A end time : " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void serviceMehtodB() {
        try {
            System.out.println("thread name : " + Thread.currentThread().getName() + ",B begin time : " + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("thread name : " + Thread.currentThread().getName() + ",B end time : " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
