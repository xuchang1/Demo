package nio_demo.selector_demo;

public class client {

    private String host;

    private int port;

    public client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private void start() {
        new Thread(new ClientHandler(host, port)).start();
    }

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;

        new client(host, port).start();
    }
}
