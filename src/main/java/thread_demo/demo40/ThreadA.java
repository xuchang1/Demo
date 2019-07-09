package thread_demo.demo40;

public class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A " + Tools.tl.get());
        }
    }
}
