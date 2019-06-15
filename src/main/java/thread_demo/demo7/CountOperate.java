package thread_demo.demo7;

/**
 * isAlive : 判断该线程是否处于活动状态，如果线程已启动并且尚未终止，则为活动状态
 */
public class CountOperate extends Thread{

    public CountOperate() {
        System.out.println("CountOperate --- begin");
        System.out.println("Thread.currentThread().getName() : " + Thread.currentThread().getName()); //main
        System.out.println("Thread.currentThread().isAlive() : " + Thread.currentThread().isAlive()); //true
        System.out.println("this.getName() : " + this.getName()); // Thread-0
        System.out.println("this.isAlive() : " + this.isAlive()); //false
        System.out.println("CountOperate --- end");
    }

    @Override
    public void run() {
        System.out.println("run --- begin");
        System.out.println("Thread.currentThread().getName() : " + Thread.currentThread().getName()); //A
        System.out.println("Thread.currentThread().isAlive() : " + Thread.currentThread().isAlive()); //true
        //TODO
        //这两个为什么这么输出？
        System.out.println("this.getName() : " + this.getName()); //Thread-0
        System.out.println("this.isAlive() : " + this.isAlive()); //false
        System.out.println("run --- end");
    }
}
