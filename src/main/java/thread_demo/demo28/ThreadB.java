package thread_demo.demo28;

public class ThreadB extends Thread {
    private Service service;

    private User user;

    public ThreadB(Service service, User user) {
        this.service = service;
        this.user = user;
    }

    @Override
    public void run() {
        service.serviceMethod1(user);
    }
}
