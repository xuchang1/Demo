package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class tools {

    public static Date transferDate(String time) {
//        time = "2019-07-09 20:25:35";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(time);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] transferBytes(int a) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) ((a & 0xff00000) >> 24);
        bytes[1] = (byte) ((a & 0xff000) >> 16);
        bytes[2] = (byte) ((a & 0xff0) >> 8);
        bytes[3] = (byte) (a & 0xff);

        return bytes;
    }
}
