package thread_demo.demo38;

public class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            Tools.t.set("A" + (i + 1));
            System.out.println("A thread name :" + Thread.currentThread().getName() + Tools.t.get());
        }
    }
}
