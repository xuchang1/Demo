package thread_demo.demo16;

/**
 * synchronized锁重入 : 调用synchronized方法之前，判断是否持有该方法所在对象的锁
 * 在service1()方法中调用synchronized方法service2()，调用service2()时判断已持有该对象锁，顾调用成功
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
