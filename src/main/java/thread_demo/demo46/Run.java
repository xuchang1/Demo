package thread_demo.demo46;

public class Run {
    public static void main(String[] args) {
        final MyService service = new MyService();

        new Thread(){
            @Override
            public void run() {
                service.method1();
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                service.method2();
            }
        }.start();
    }
}
