package thread_demo.demo1;

/**
 * 注意与demo2进行比较，demo1中count变量是不共享的，demo2中共享
 * 原因 :
 *      demo1实例化不同的MyThread对象，访问的count也是通过相应不同的对象访问的
 *      demo2中，通过同一个myThread对象，来实例化Thread对象，线程启动时，访问count变量，都是通过同一个myThread对象来访问的，固此时变量线程共享
 *
 * 即 : 判断成员变量是否共享，要看该变量所属对象是否为同一对象
 *      为了实现变量的共享，即可将该变量所属对象作为参数，保持不变
 */
public class Run {
    public static void main(String[] args) {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
    }
}
