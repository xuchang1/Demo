package thread_demo.demo26;

public class ThreadB extends Thread{
    @Override
    public void run() {
        String b = "aa";
        Service.print(b);
    }
}
