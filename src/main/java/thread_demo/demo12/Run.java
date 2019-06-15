package thread_demo.demo12;

/**
 * 1、setPriority(int priority); 设置该线程的优先级，优先级范围 1-10
 * 2、Thread.MIN_PRIORITY = 1,Thread.NORM_PRIORITY = 5, Thread.MAX_PRIORITY = 10，Thread类自带的3个优先级常量，一般创建的线程，优先级默认为Thread.NORM_PRIORITY
 * 3、线程的优先级是有继承特性的，如果在线程A中创建线程B，那么线程B的优先级和线程A一样
 *4、优先级高的线程，只有有可能先获得cpu时间片，而不是一定
 */
public class Run {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setPriority(10);
        myThread1.start();

        MyThread2 myThread2 = new MyThread2();
        myThread2.setPriority(1);
        myThread2.start();
    }
}
