package thread_demo.demo28;

/**
 * 只要对象不变，即使对象的属性被改变，结果仍然是同步的
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        user.setName("abc");
        Service service = new Service();

        ThreadA threadA = new ThreadA(service, user);
        threadA.start();

        Thread.sleep(2000);

        ThreadB threadB = new ThreadB(service, user);
        threadB.start();
    }
}
