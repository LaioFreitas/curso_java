package entities;
import entities.enums.WorkLevel;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Worker {

    private String name;
    private WorkLevel level;
    private Double baseSalary;
    private List<HourContract> contracts = new ArrayList<>();
    private Departament departament;
    
    public Worker() {}
    
    public Worker(String name, WorkLevel level, Double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLevel(WorkLevel level) {
        this.level = level;
    }

    public WorkLevel getLevel() {
        return level;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }
    
    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public Departament getDepertament() {
        return departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }
    public Double income(int year, int month) {
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts) {
            cal.setTime(c.getDate());
            if (year == cal.get(Calendar.YEAR) && month == cal.get(Calendar.MONTH)) {
                sum += c.totalValue();
            }
        }   
        return sum;
    }
}
