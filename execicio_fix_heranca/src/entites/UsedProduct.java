package entites;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {

    private Date monofactureDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, Double price, Date monofactureDate) {
        super(name, price);
        this.monofactureDate = monofactureDate;
    }

    public Date getMonofactureDate() {
        return monofactureDate;
    }

    public void setMonofactureDate(Date monofactureDate) {
        this.monofactureDate = monofactureDate;
    }

    @Override
    public String priceTag() {
        return String.format("%s (used) $ %.2f (Monofacture date: %s)", name, price, sdf.format(monofactureDate));
    }
}
