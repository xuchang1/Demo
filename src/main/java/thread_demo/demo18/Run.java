package thread_demo.demo18;

/**
 * 出现异常，锁会自动释放。若该异常被捕获，则锁不会释放
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThreadA myThreadA = new MyThreadA(service);
        myThreadA.setName("a");
        myThreadA.start();

        Thread.sleep(500);

        MyThreadB myThreadB = new MyThreadB(service);
        myThreadB.setName("b");
        myThreadB.start();
    }
}
