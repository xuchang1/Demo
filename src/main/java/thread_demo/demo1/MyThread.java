package thread_demo.demo1;

public class MyThread extends Thread {
    private int count = 5;

    public MyThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println("由" + this.currentThread().getName() + "计算，count = " + count);
        }
    }
}
