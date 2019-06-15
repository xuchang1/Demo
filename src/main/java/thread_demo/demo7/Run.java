package thread_demo.demo7;

public class Run {
    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t = new Thread(c);
        System.out.println("main begin t isAlive : " + t.isAlive());
        t.setName("A");
        t.start();
        System.out.println("main end t isAlive : " + t.isAlive());
    }
}
