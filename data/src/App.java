import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");       
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");       

        LocalDate do1 = LocalDate.now();
        System.out.println(do1);
        Instant d03 = Instant.now();
        LocalDate d04 = LocalDate.parse("2001-12-27");
        LocalDateTime d02 = LocalDateTime.now();
        LocalDateTime d05 = LocalDateTime.parse("2001-12-27T12:21:34");       
        Instant d06 = Instant.parse("2021-12-27T23:43:88z");
        Instant d07 = Instant.parse("2021-12-27T23:43:88-03:00");
        System.out.println(d02);
        System.out.println(d04);

        LocalDate d08 = LocalDate.parse("21/12/2001", fmt1);
        LocalDate d09 = LocalDate.parse("21/12/2001 10:23", fmt2);
        
        System.out.println(d08);
        System.out.println(d09); 

        LocalDate d10 = LocalDate.of(2011, 02, 9);
       //LocalDate d11 = LocalDate.of(2014, 12, 28, 2, 40);
        //De data para texto.
       
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt6 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt7 = DateTimeFormatter.ISO_INSTANT;
        
        System.out.println(d08.format(fmt3));
        System.out.println(fmt3.format(d08));
        System.out.println(d08.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(fmt5.format(d06));
       
    }
}
