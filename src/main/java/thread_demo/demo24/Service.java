package thread_demo.demo24;

public class Service {
    synchronized public static void printA() {
        try {
            System.out.println("thread name : " + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + " 进入printA");
            Thread.sleep(2000);
            System.out.println("thread name : " + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + " 离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        try {
            System.out.println("thread name : " + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + " 进入printB");
            Thread.sleep(2000);
            System.out.println("thread name : " + Thread.currentThread().getName() + " 在" + System.currentTimeMillis() + " 离开printB");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
