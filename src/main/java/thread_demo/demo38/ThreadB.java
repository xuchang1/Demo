package thread_demo.demo38;

public class ThreadB extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Tools.t.set("B" + (i + 1));
            System.out.println("B thread name :" + Thread.currentThread().getName() + Tools.t.get());
        }
    }
}
