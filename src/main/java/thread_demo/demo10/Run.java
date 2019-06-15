package thread_demo.demo10;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        /*MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        Thread.sleep(10000);
        myThread1.setFlag(false);*/

        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        Thread.sleep(1000);
        myThread2.interrupt();
    }
}
