import entities.*;

public class App {
    public static void main(String[] args) throws Exception {
        Account acc = new Account(1001, "alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "maria", 0.0, 500.0);

        //upacasting 

        Account acc2 = bacc; 
        Account acc3 = new BusinessAccount(1003, "bob", 0.0, 500.0);
        Account acc4 = new SavingAccount(1004, "anna", 0.0, 0.01);
        
        //downcasting
        
        BusinessAccount acc5 = (BusinessAccount) acc3;
        acc5.loan(100.0);

        if (acc4 instanceof BusinessAccount) {
            BusinessAccount acc6 = (BusinessAccount)acc4;
            acc6.loan(200.0);
            System.out.println("loan!");
        }

        if (acc4 instanceof SavingAccount) {
            SavingAccount acc6 = (SavingAccount)acc4;
            acc6.updateBalance();
            System.out.println("update");
        }
            
        
    }
}
