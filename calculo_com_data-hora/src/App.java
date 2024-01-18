import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
public class App {
    public static void main(String[] args) throws Exception { 
        LocalDate d04 = LocalDate.parse("2022-07-12");
        LocalDateTime d05 = LocalDateTime.parse("2021-02-22T12:32:54");
        Instant d06 = Instant.parse("2018-12-22T01:53:14z");

        LocalDate pastWeekLocalDate = d04.minusWeeks(1);
        LocalDate nextWeekLocalDate = d04.plusWeeks(1);
        System.out.println(pastWeekLocalDate);
        System.out.println(nextWeekLocalDate);

        LocalDateTime pastWeekLocalDateTime = d05.minusWeeks(1);
        LocalDateTime nextWeekLocalDateTime = d05.plusWeeks(1);
        System.out.println(pastWeekLocalDateTime);
        System.out.println(nextWeekLocalDateTime);
        
        Instant pastWeekInstant = d06.minus(1, ChronoUnit.WEEKS);
        Instant nextWeekInstant = d06.plus(1, ChronoUnit.WEEKS);
        System.out.println(pastWeekInstant);
        System.out.println(nextWeekInstant);

        Duration t1 = Duration.between(pastWeekLocalDate.atTime(0, 0), d04.atTime(0, 0));
        Duration t2 = Duration.between(pastWeekLocalDateTime, d05);
        Duration t3 = Duration.between(pastWeekInstant, d06);

        System.out.println(t1.toDays());
        System.out.println(t2.toDays());
        System.out.println(t3.toDays());
    }
}
