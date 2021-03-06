package nio_demo.selector_demo;

import java.io.IOException;

public class Server {

    private int port;

    public Server(int port) {
        this.port = port;
    }

    private void start() throws IOException {
       new Thread( new serverHandler(port)).start();
    }

    public static void main(String[] args) throws IOException {
        int port = 8080;

        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        new Server(port).start();
    }


}
