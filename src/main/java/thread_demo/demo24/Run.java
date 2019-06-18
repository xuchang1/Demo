package thread_demo.demo24;

/**
 * Class锁对所有该类对象实例都起作用
 *
 * 不同的对象，访问不同的synchronized静态方法，需要获取的是同一把class锁，顾同步
 */
public class Run {
    public static void main(String[] args) {
        Service service1 = new Service();
        Service service2 = new Service();

        ThreadA threadA = new ThreadA(service1);
        threadA.start();

        ThreadB threadB = new ThreadB(service2);
        threadB.start();
    }
}
