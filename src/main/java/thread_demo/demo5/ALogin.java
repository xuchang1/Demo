package thread_demo.demo5;

public class ALogin extends Thread{
    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}
