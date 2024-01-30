package entites;
import entites.enums.*;
public class Retangule extends Shape {

    private Double height;
    private Double widgth;

    public Retangule() { super(); }

    public Retangule(Double height, Double widgth, Color color) {
        super(color);
        this.height = height;
        this.widgth = widgth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
    
    public Double getWidgth() {
        return widgth;
    }

    public void setWidgth(Double widgth) {
        this.widgth = widgth;
    }

    @Override
    public double area() {
        return height * widgth;
    }
}
