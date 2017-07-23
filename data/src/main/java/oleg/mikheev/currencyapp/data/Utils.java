package oleg.mikheev.currencyapp.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Oleg on 20.05.2017.
 */
public class Utils {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String getFormattedDate(Date date) {
        return dateFormat.format(date);
    }

    public static Date getFormattedDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
