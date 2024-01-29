import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the number of employees: ");
        int quantityEmployees = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < quantityEmployees; ++i) {
            System.out.print("Outsourced (y/n)? ");
            char option = sc.next().toUpperCase().charAt(0);
            Employee employee;

            System.out.print("name: ");
            String name = sc.nextLine();

            System.out.print("hours: ");
            int hours = sc.nextInt();

            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            
            if (option == 'Y') {
                System.out.print("Additional charge: ");
                Double additionalCharge = sc.nextDouble();

                employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
            }
            else {
                employee = new Employee(name, hours, valuePerHour);
            }

            employees.add(employee);
        }
        sc.close();

        System.out.print("PAYMENTS:");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}
