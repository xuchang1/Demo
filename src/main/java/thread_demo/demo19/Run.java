package thread_demo.demo19;

public class Run {
    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ThreadA threadA = new ThreadA(service);
        threadA.start();

        ThreadB threadB = new ThreadB(service);
        threadB.start();
    }
}
