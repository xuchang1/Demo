package niodemo.testio;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class test2 {
    public static void main(String[] args) {
        File file = new File("D:\\Workspace\\Study\\test\\testio\\hello.txt");
        File fileZip = new File("D:\\Workspace\\Study\\test\\testio\\hello.zip");

        FileInputStream input = null;
        ZipOutputStream zipOut = null;
        try {
            input = new FileInputStream(file);
            zipOut = new ZipOutputStream(new FileOutputStream(fileZip));

            zipOut.putNextEntry(new ZipEntry(file.getName()));
            zipOut.setComment("hello1");

            int temp = 0;
            while ((temp = input.read()) != -1) {
                zipOut.write(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (zipOut != null) {
                try {
                    zipOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
