package thread_demo.demo39;

import java.util.Date;

public class ThreadB extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B thread name : " + Thread.currentThread().getName() + " " + Tools.t.get());
            Tools.t.set(new Date());
        }
    }
}
