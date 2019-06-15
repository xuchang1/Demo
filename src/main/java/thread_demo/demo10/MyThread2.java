package thread_demo.demo10;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        int i = 0;

        while (true) {
            System.out.println("i = " + i++);

            /*try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }*/

            if (Thread.interrupted()) {
                break;
            }
        }

        System.out.println("退出循环");
    }
}
