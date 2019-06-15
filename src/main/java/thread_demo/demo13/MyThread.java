package thread_demo.demo13;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("调用线程 : " + Thread.currentThread().getName());
    }
}
