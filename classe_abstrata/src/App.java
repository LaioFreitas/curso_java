import java.util.ArrayList;
import java.util.List;

import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        Account acc1 = new BusinessAccount(1001, "mario", 0.00, 500.0);

        List<Account> list = new ArrayList<>();
        list.add(acc1); 
        list.add(new SavingAccount(1002, "ga", 300.0, 0.02));
        list.add(new BusinessAccount(1003, "bob", 400.0, 100.0));

        double sum = 0;
        for (Account account : list) {
            sum += account.getBalance();
        }
        System.out.println(sum);
    }
}
