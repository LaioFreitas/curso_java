import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();

        System.out.print("Holder: ");
        String holder = sc.nextLine();

        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();

        System.out.print("Withdraw limit: ");
        double withDrawLimit = sc.nextDouble();
        Account account = new Account(number, holder, initialBalance, withDrawLimit);

        System.out.print("enter amount for withdraw: ");
        double amount = sc.nextDouble();

        sc.close();

        account.withdraw(amount);

        System.out.printf("New balance: %.2f", account.getBalance());
    }
}
