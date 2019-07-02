package thread_demo.demo34;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产消费者模式
 *      一生产与一消费
 */
public class Run {
    public static void main(String[] args) {
        Object lock = new Object();
        List list = new ArrayList<>();

        ThreadA threadA = new ThreadA(lock, list);
        threadA.start();

        ThreadB threadB = new ThreadB(lock, list);
        threadB.start();
    }
}
