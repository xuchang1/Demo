package thread_demo.demo2;

public class MyThread extends Thread {
    private int count = 5;

    @Override
    public void run() {
        count--;
        System.out.println("由 " + this.currentThread().getName() + "计算,count = " +count);
    }
}
