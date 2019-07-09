package thread_demo.demo39;

import java.util.Date;

public class ThreadA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A thread name : " + Thread.currentThread().getName() + " " + Tools.t.get());
            Tools.t.set(new Date());
        }
    }
}
