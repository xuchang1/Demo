package thread_demo.demo22;

public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.SetUserNamePassword("b", "bb");
    }
}
