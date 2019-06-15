package thread_demo.demo14;

/**
 * 守护线程 : 当进程中不存在非守护线程了，则守护线程自动销毁
 * setDaemon : true : 设置该线程为守护新出; false : 设置该线程为用户线程
 * isDaemon : 判断该线程是否为守护线程
 */
public class MyThread extends Thread {
    private int i;

    @Override
    public void run() {
        while (true) {
            System.out.println("i = " + i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("---------------");
        }
    }
}
