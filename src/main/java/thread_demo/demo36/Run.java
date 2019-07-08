package thread_demo.demo36;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
    public static void main(String[] args) throws IOException, InterruptedException {
        WriteData write = new WriteData();
        ReadData read = new ReadData();

        PipedInputStream input = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();

//        out.connect(input);
        input.connect(out);


        new Thread(new ThreadRead(read, input)).start();

        Thread.sleep(2000);

        new Thread(new ThreadWrite(write, out)).start();

    }
}
