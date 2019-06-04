package niodemo.testio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test5 {
    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader("D:/Workspace/Study/test/testio/demo.txt");
            writer = new FileWriter("D:/Workspace/Study/test/testio/demo2.txt");

            int ch = 0;
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }

            if (writer != null) {
                writer.close();
            }
        }
    }
}
