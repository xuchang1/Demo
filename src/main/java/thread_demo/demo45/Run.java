package thread_demo.demo45;

/**
 * 使用Condition实现顺序执行任务。
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();

        new Thread1(service).start();
        new Thread2(service).start();
        new Thread3(service).start();
    }
}
