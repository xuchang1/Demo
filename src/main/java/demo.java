import sun.nio.cs.UTF_32;
import sun.text.normalizer.UTF16;
import utils.tools;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * COUNT_BITS = 29;
 * CAPACITY :    00011111 111111111 11111111;
 * RUNNING :     11100000 00000000 00000000;
 * SHUTDOWN :    00000000 00000000 00000000;
 * STOP :        00100000 00000000 00000000;
 * TIDYING :     01000000 00000000 00000000;
 * TERMINATED :  01100000 00000000 00000000;
 */
public class demo {
    public static void main(String[] args) {
        /*int a = 1;
        int b = 2;

        if ((a == 1) || ((b = 3) ==3)) {
            System.out.println(b);
        }*/


        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));*/

//        System.out.println(tools.transferDate(""));


        long a = 192;
        byte[] bytes = new byte[4];
        bytes[0] = (byte) ((a & 0xff000000) >>24);
        bytes[1] = (byte) ((a & 0xff0000) >>16);
        bytes[2] = (byte) ((a & 0xff00) >>8);
        bytes[3] = (byte) (a & 0xff);

        System.out.println(new String(bytes));

        /*String  a = "中国";
        byte[] bytes = a.getBytes();
        System.out.println(bytes.length);
        System.out.println(new String(bytes));*/
    }
}
