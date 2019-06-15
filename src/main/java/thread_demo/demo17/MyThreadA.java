package thread_demo.demo17;

public class MyThreadA extends Thread {

    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateSubMethod();
    }
}
