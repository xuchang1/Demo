package thread_demo.demo8;

/**
 * sleep() : 当前正在运行的线程休眠一定时间(暂停执行)
 */
public class Run2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        System.out.println("begin = " + System.currentTimeMillis());
        myThread2.start();
        System.out.println("end = " + System.currentTimeMillis());
    }
}
