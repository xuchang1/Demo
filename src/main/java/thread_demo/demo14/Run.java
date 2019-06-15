package thread_demo.demo14;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();

        Thread.sleep(5000);
        System.out.println("主线程结束！");
    }
}
