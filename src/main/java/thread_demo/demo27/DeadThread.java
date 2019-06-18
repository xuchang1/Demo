package thread_demo.demo27;

public class DeadThread implements Runnable {

    private String username;

    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        if ("a".equals(username)) {
            synchronized (lock1) {
                try {
                    System.out.println("thread name : " + Thread.currentThread().getName() + " 进入lock1");
                    Thread.sleep(3000);
                    synchronized (lock2) {
                        System.out.println("thread name : " + Thread.currentThread().getName() + " 进入lock2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if ("b".equals(username)) {
            synchronized (lock2) {
                try {
                    System.out.println("thread name : " + Thread.currentThread().getName() + " 进入lock2");
                    Thread.sleep(3000);
                    synchronized (lock1) {
                        System.out.println("thread name : " + Thread.currentThread().getName() + " 进入lock1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
