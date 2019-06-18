package thread_demo.demo28;

public class Service {
    public void serviceMethod1(User user) {
        synchronized (user) {
            try {
                System.out.println("thread name : " + Thread.currentThread().getName() + " begin time = " + System.currentTimeMillis());
                user.setName("efg");
                Thread.sleep(3000);
                System.out.println("thread name : " + Thread.currentThread().getName() + " end time = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
