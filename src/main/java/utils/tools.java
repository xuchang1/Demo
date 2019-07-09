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
}
