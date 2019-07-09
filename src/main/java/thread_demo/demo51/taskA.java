package thread_demo.demo51;

import java.util.Date;
import java.util.TimerTask;

public class taskA extends TimerTask {
    @Override
    public void run() {
        System.out.println("taskA begin at " + new Date());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("taskA end at " + new Date());
    }
}
