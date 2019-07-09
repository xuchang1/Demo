package thread_demo.demo50;

import utils.tools;

/**
 * schedule(TimerTask task,Date time) : 指定的时间执行该任务。
 *
 * schedule(TimerTask task,long delay) : 指定的延迟后，执行该任务(单位毫秒)。
 *
 * 任务的实际执行时间，可能会因为上个任务执行时间较长而被延后。
 */
import java.util.Timer;

public class Run {
    public static void main(String[] args) {
        Timer timer = new Timer();
        taskA taskA = new taskA();
        taskB taskB = new taskB();
        /*String time1 = "2019-07-09 22:57:00";
        String time2 = "2019-07-09 22:57:02";
        timer.schedule(taskA, tools.transferDate(time1));
        timer.schedule(taskB, tools.transferDate(time2));*/

        timer.schedule(taskA, 1000);
        timer.schedule(taskB, 1000);
    }
}
