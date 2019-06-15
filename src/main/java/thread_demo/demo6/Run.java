package thread_demo.demo6;

/**
 * Thread.currentThread()获取当前正在执行的线程对象的引用
 * 在main方法中，通过主线程， 初始化CountOperate对象，run方法是线程A在调用
 */
public class Run {
    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread thread = new Thread(c);
        thread.setName("A");
        thread.start();
    }
}
