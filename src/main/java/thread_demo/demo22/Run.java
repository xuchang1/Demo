package thread_demo.demo22;

/**
 * java支持将任意对象作为对象监视器来实现同步功能
 * 是否同步注意synchronized修饰的是否为同一对象
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
