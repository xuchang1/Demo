package thread_demo.demo19;

public class ThreadA extends Thread {

    private ObjectService service;

    public ThreadA(ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethod();
    }
}
