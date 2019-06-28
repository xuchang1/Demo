package thread_demo.demo29;

public class PrintString implements Runnable{

    private volatile boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void printStringMethod() {
        try {
            while (flag) {
                System.out.println("thread name : " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        printStringMethod();
    }
}
