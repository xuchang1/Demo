package thread_demo.demo42;

/**
 * Condition : 通过ReentrantLock对象调用newCondition方法生成，一个ReentrantLock对象可以产生多个Condition对象。
 *
 * Condition的await、signal方法使用方式和wait/notify一致，必须在其所属的lock对象同步的代码块中调用。哪个Condition对象await的，必须
 *      该对象进行唤醒。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        ThreadA threadA = new ThreadA(service);
        threadA.start();

        ThreadB threadB = new ThreadB(service);
        threadB.start();

        Thread.sleep(2000);
        service.signalA();
    }
}
