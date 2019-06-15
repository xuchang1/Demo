package thread_demo.demo15;

public class MyObject {
    public synchronized void mehtodA() {
        try {
            System.out.println("begin methodA threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end endTime = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //通过两个线程，分别调用同一对象的不同方法，理解有没有synchronized修饰的区别
    public synchronized void methodB() {
        try {
            System.out.println("begin methodB threadName = " + Thread.currentThread().getName() + " begin time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
