package enetitties;

public class PhysicalPerson extends Person {

    private Double healthSpending;

    public PhysicalPerson() { super(); }

    public PhysicalPerson(String name, Double annualIncome, Double healthSpending) {
        super(name, annualIncome);
        this.healthSpending = healthSpending;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpanding) {
        this.healthSpending = healthSpanding;
    }

    @Override
    public double tax() {
        double tax;

        if (getAnnualIncome() < 20000) {
            tax = getAnnualIncome() * 0.15;
        }
        else {
            tax = getAnnualIncome() * 0.25;
        }

        if (healthSpending > 0) {
            tax -= healthSpending * 0.5;
        }

        return tax;
    }
}
