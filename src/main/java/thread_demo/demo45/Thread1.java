package thread_demo.demo45;

public class Thread1 extends Thread{

    private MyService service;

    public Thread1(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true)
            service.menthod1();
    }
}
