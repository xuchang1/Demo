package thread_demo.demo17;

/**
 * 锁重入具有继承性 : 子类可以通过锁重入，调用父类的同步方法
 */
public class Run {
    public static void main(String[] args) {
        MyThreadA myThreadA = new MyThreadA();
        myThreadA.start();
    }
}
