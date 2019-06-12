package nio_demo.testbio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable {
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            String currentTime = null;
            String body = null;

            //readLine()方法是阻塞的，客户端数据传输完成后，注意close操作，不然会报Connection reset异常
            while ((body = reader.readLine()) != null) {
                System.out.println("ServerTime ：" + Thread.currentThread() + "get orader ：" + body);
                currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "Bad Order";
                writer.println(currentTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (writer != null) {
                writer.close();
                writer = null;
            }

            if (socket != null) {
                try {
                    socket.close();
                    this.socket = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
