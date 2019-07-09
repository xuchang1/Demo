package thread_demo.demo44;

/**
 * tryLock(long timeout,TimeUnit unit) : 在等待的时间内，会一直重复尝试去获得该锁，而不是指定的时间之后再去获取锁。
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();

        MyThread threadA = new MyThread(service);
        threadA.setName("A");

        MyThread threadB = new MyThread(service);
        threadB.setName("B");

        threadA.start();
        threadB.start();
    }
}
