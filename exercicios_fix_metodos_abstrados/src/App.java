import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import enetitties.*;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int  numberOfTaxPayment = sc.nextInt();
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < numberOfTaxPayment; ++i) {
            System.out.printf("Tax payer #%d data:\n");
            System.out.print("Individual or company (i/c)? ");
            char option = sc.next().toUpperCase().charAt(0);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Anual Income: ");
            Double annualIncome = sc.nextDouble();

            if (option == 'C') {
                System.out.print("number of employees: ");
                int numberOfEmployees = sc.nextInt();

                persons.add(new LegalPerson(name, annualIncome, numberOfEmployees));                
            }
            else if (option == 'I') {
                System.out.print("health expenditures: ");
                double healthSpending = sc.nextDouble();

                persons.add(new PhysicalPerson(name, annualIncome, healthSpending));
            }
        }
        sc.close();

        double totalTax = 0;
        for (Person person : persons) {
            System.out.println(person.toString());

            totalTax += person.tax();
        }

        System.out.println("")

    }
}
