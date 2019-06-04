package niodemo.testbio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient2 {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            port = Integer.valueOf(args[0]);
        }

        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            socket = new Socket("127.0.0.1", port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            Thread.sleep(5000);

            String order = "QUERY TIME ORDER";
            writer.println(order);
            System.out.println("send to time server order ：" + order);

            String body = reader.readLine();
            System.out.println("time server rev ：" + body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                reader = null;
            }

            if (writer != null) {
                writer.close();
                writer = null;
            }
        }
    }
}
