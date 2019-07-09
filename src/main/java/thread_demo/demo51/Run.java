package thread_demo.demo51;

import java.util.Timer;

/**
 * 周期性的执行任务
 * schedule和scheduleAtFixedRate方法的区别
 *      schedule : 从上次任务开始执行时间，间隔period时间，计划执行下次任务(根据任务实际开始的时间进行间隔).
 *      scheduleAtFixedRate : 从上次任务的计划时间，间隔period时间，计划执行下次任务(固定的频率增加，而不管实际执行情况)。
 */
public class Run {

    public static void main(String[] args) {
        Timer timer = new Timer();

        taskA taskA = new taskA();
        taskB taskB = new taskB();

//        timer.schedule(taskA, 1000, 7000);
//        timer.schedule(taskB, 2000);

        timer.scheduleAtFixedRate(taskA, 1000, 7000);
        timer.schedule(taskB, 2000);
    }
}
