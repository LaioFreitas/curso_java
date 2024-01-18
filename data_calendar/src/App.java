import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class App {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

        Date x1 = new Date();
        Date x2 = new Date(System.currentTimeMillis());
        Date y1 = sdf1.parse("27/12/2011");
        Date y2 = sdf2.parse("17/04/2009 15:32:12");
        Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07z"));

        System.out.println(y1);
        System.out.println(y2);
        System.out.println(sdf1.format(y1));
        System.out.println(sdf2.format(y2));
        System.out.println(sdf2.format(x1));
        System.out.println(sdf2.format(x2));
        System.out.println(sdf3.format(y3)); 
        // 

        Calendar cal = Calendar.getInstance();
        cal.setTime(y3);
        cal.add(Calendar.HOUR_OF_DAY, 4);
        y3 = cal.getTime();
        System.out.println(sdf3.format(y3));

        int minutes = cal.get(Calendar.MINUTE);
        int month = cal.get(Calendar.MONTH);
        System.out.println(minutes);
        System.out.println(month + 1); 
    }
}
