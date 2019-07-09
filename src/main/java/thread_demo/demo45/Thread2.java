package thread_demo.demo45;

public class Thread2 extends Thread {

    private MyService service;

    public Thread2(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true)
            service.menthod2();
    }
}
