import utils.tools;

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

        System.out.println(tools.transferDate(""));
    }
}
