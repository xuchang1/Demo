package thread_demo.demo25;

/**
 * synchronized(x.class) : 同步代码块，监视对象为类x，访问需要向获取类x的class锁
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();

        ThreadA threadA = new ThreadA(service);
        threadA.start();

        ThreadB threadB = new ThreadB(service);
        threadB.start();
    }
}
