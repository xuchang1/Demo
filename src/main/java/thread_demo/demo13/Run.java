package thread_demo.demo13;

/**
 * 线程的优先级具有继承特性，即在线程A中创建线程B，那么线程B的优先级和线程A一样
 */
public class Run {
    public static void main(String[] args) {
        System.out.println("线程 : " + Thread.currentThread().getName() + " 的优先级为 : " + Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(6);
        System.out.println("线程 : " + Thread.currentThread().getName() + " 的优先级为 : " + Thread.currentThread().getPriority());

        MyThread myThread = new MyThread();
        System.out.println("线程 : " + myThread.getName() + " 的优先级为 : " + myThread.getPriority());
    }
}
