package entities;

public class BusinessAccount extends Account {

    private Double loanLimit;

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit; 
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount) {
        if (amount <= loanLimit) {
            balance += amount - 10;
        }
        else {
            System.out.println("o valor desejado é maior que o limite de enprestimo!");
        }
    }
    
    @Override 
    public void withDraw(double amount) {
        super.withDraw(amount);
        balance -= 2.0;
    }

}
