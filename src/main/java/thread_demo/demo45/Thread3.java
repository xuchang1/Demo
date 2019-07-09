package thread_demo.demo45;

public class Thread3 extends Thread {

    private MyService service;

    public Thread3(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true)
            service.menthod3();
    }
}
