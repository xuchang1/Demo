package thread_demo.demo36;

import java.io.PipedInputStream;

public class ThreadRead implements Runnable{

    private ReadData read;

    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
