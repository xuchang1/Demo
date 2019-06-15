package thread_demo.demo5;

public class BLogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("b", "bb");
    }
}
