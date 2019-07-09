package thread_demo.demo40;

public class Run {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Main " + Tools.tl.get());
        }
    }
}
