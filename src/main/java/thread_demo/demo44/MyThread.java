package thread_demo.demo44;

public class MyThread extends Thread {

    private MyService service;

    public MyThread(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        System.out.println("at " + System.currentTimeMillis() + " 尝试去获取锁");
        service.method();
    }
}
