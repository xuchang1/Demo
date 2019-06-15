package thread_demo.demo5;

public class Run {
    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        aLogin.start();

        BLogin bLogin = new BLogin();
        bLogin.start();
    }
}
