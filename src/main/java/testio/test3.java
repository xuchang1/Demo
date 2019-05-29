package testio;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class test3 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Workspace\\Study\\test\\testio\\hello.zip");
        ZipFile zipFile = new ZipFile(file);

        ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));

        File outFile = null;
        ZipEntry entry = null;
        InputStream input = null;
        OutputStream output = null;

        while ((entry = zipInput.getNextEntry()) != null) {
            System.out.println("解压缩" + entry.getName() + "文件");
            outFile = new File(file.getParent() + File.separator + entry.getName());
        }
    }
}
