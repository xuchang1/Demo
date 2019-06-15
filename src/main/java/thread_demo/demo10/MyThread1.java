package thread_demo.demo10;

/**
 * 通过设置退出标记，从而达到退出线程循环的目的
 */
public class MyThread1 extends Thread {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("循环结束");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
