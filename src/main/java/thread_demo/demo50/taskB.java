package thread_demo.demo50;

import java.util.Date;
import java.util.TimerTask;

public class taskB extends TimerTask {
    @Override
    public void run() {
        System.out.println("taskB begin at " + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("taskB end at " + new Date());
    }
}
