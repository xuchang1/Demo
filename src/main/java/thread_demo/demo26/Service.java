package thread_demo.demo26;

public class Service {
    public static void print(String param) {
        try {
            synchronized (param) {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
