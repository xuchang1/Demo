package thread_demo.demo36;

import java.io.PipedOutputStream;

public class ThreadWrite implements Runnable{

    private WriteData write;

    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethdo(out);
    }
}
