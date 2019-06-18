package thread_demo.demo28;

public class ThreadA extends Thread {
    private Service service;

    private User user;

    public ThreadA(Service service, User user) {
        this.service = service;
        this.user = user;
    }

    @Override
    public void run() {
        service.serviceMethod1(user);
    }
}
