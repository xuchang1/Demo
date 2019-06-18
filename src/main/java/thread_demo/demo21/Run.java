package thread_demo.demo21;

/**
 * 线程A、B虽然访问不同方法，但是都要先获取这些方法的同一个对象service的锁，顾不同方法之间同步
 */
public class Run {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ThreadA threadA = new ThreadA(service);
        threadA.start();

        ThreadB threadB = new ThreadB(service);
        threadB.start();
    }
}
