package thread_demo.demo48;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        final MyService service = new MyService();

        new Thread(){
            @Override
            public void run() {
                service.method1();
            }
        }.start();

        Thread.sleep(100);

        new Thread() {
            @Override
            public void run() {
                service.method2();
            }
        }.start();
    }
}
