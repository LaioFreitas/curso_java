import java.time.Instant;
import java.time.LocalDate;
// import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Scanner;
import entities.enums.WorkLevel;
import entities.Worker;
import entities.Departament;
import entities.HourContract;


public class App {
    public static void main(String[] args) throws Exception {
 
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter departament name: ");
        Departament departament = new Departament(sc.nextLine());
        
        System.out.println("Enter worker data:");
        
        System.out.print("name: ");
        String name = sc.nextLine();
        
        System.out.print("level: ");
        WorkLevel level = WorkLevel.valueOf(sc.nextLine());
        
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();
        Worker w = new Worker(name, level, baseSalary, departament);

        System.out.print("how many contracts to this worker? ");
        int contractQuantity = sc.nextInt();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (int i = 0; i < contractQuantity; ++i) {
            System.out.printf("enter contract #%d data", i + 1);
            System.out.print("Date (dd/MM/yyyy): ");
            Instant date = LocalDate.parse(sc.next(), fmt).atStartOfDay(ZoneId.systemDefault()).toInstant();

            System.out.print("value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int durationHour = sc.nextInt();

            w.addContract(new HourContract(date, valuePerHour, durationHour));
        }
        System.out.print("enter month and year to calculate income (MM/yyyy): ");
        DateTimeFormatter fmt2  = DateTimeFormatter.ofPattern("MM/yyyy").withZone(ZoneId.systemDefault());
        // LocalDate dateChosen = new LocalDate();
        Instant dateChosen = LocalDate.parse(sc.next(), fmt2).atStartOfDay(ZoneId.systemDefault()).toInstant();

        // Instant datechosen = Instant.from(LocalDate.parse(sc.next(), fmt2).atTime(0, 0, 0));
        double incomeValue = w.income(dateChosen.get(ChronoField.YEAR), dateChosen.get(ChronoField.MONTH_OF_YEAR));
        sc.close();

        System.out.printf("Name: %s", w.getName());
        System.out.printf("Departament: %s", w.getDepartament().getName());
        System.out.printf("income for %s: %.2f", fmt2.format(dateChosen), incomeValue);
    }
}
