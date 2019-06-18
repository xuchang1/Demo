package thread_demo.demo21;

public class ThreadA extends Thread {
    private ObjectService service;

    public ThreadA(ObjectService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.serviceMethodA();
    }
}
