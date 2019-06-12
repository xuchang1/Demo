package nio_demo.testio;

import java.io.*;

public class test6 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputReader = null;
        OutputStreamWriter outWriter = null;

        try {
            inputReader = new InputStreamReader(new FileInputStream("D:/Workspace/Study/test/testio/科技项目执行情况年度报告.docx"), "UTF-8");
            outWriter = new OutputStreamWriter(new FileOutputStream("D:/Workspace/Study/test/testio/demo.docx"), "UTF-8");
            int ch = 0;
            while ((ch = inputReader.read()) != -1) {
                outWriter.write(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputReader != null) {
                inputReader.close();
            }

            if (outWriter != null) {
                outWriter.close();
            }
        }

    }
}
