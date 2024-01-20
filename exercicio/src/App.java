import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import entities.enums.WorkLevel;
import entities.Worker;
import entities.Departament;
import entities.HourContract;

import java.util.Calendar;
import java.util.Date;

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
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < contractQuantity; ++i) {
            System.out.printf("enter contract #%d data", i + 1);
            System.out.print("Date (dd/MM/yyyy): ");
            Date date = fmt.parse(sc.next());

            System.out.print("value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int durationHour = sc.nextInt();

            w.addContract(new HourContract(date, valuePerHour, durationHour));
        }
        System.out.print("enter month and year to calculate income (MM/yyyy): ");
        SimpleDateFormat fmt2  = new SimpleDateFormat("MM/yyyy");
        Date dateChosen = fmt2.parse(sc.next());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateChosen);
        double incomeValue = w.income(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH));
        sc.close();

        System.out.printf("Name: %s", w.getName());
        System.out.printf("Departament: %s", w.getDepartament().getName());
        System.out.printf("income for %s: %.2f", fmt2.format(dateChosen), incomeValue);
    }
}
