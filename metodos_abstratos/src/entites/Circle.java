package entites;
import entites.enums.Color;
public class Circle extends Shape {

    private Double radius;
    private static Double PI = 3.1415;
    public Circle() { super(); }

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }
    
    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * Math.pow(radius, 2.0);
    }
}
