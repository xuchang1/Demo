package thread_demo.demo23;

/**
 * synchronized修饰静态方法，获取的是当前类(class)的锁
 *
 * 该示例中，threadA、threadB都获取类的锁，顾同步，threadC获取的对象service的锁，顾和前两者不同步
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();

        ThreadA threadA = new ThreadA(service);
        threadA.start();

        ThreadB threadB = new ThreadB(service);
        threadB.start();

        ThreadC threadC = new ThreadC(service);
        threadC.start();
    }
}
