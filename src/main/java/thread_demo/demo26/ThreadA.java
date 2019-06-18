package thread_demo.demo26;

public class ThreadA extends Thread{
    @Override
    public void run() {
        String a = "aa";
        Service.print(a);
    }
}
