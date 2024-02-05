package enetitties;

public class LegalPerson extends Person {

    private Integer numberOfEmployees;

    public LegalPerson() { super(); }

    public LegalPerson(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getnumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double tax() {
        double tax;
        if (numberOfEmployees > 10) {
            tax = getAnnualIncome() * 0.14; 
        }
        else {
            tax = getAnnualIncome() * 0.16;
        }
        return tax;
    }
}
