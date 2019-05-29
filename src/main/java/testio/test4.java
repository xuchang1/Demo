package testio;

import java.io.FileWriter;
import java.io.IOException;

public class test4 {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("D:/Workspace/Study/test/testio/demo.txt");
        writer.write("abc");
        writer.flush();
        writer.write("defg");
        writer.close();
    }
}
