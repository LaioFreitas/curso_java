import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entites.*;
import entites.enums.Color;
public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the nunber of shape: ");
        int quantityOfShape = sc.nextInt();
        List<Shape> shapes = new ArrayList<>();

        for (int i = 0; i < quantityOfShape; ++i) {
            System.out.printf("Shape #%d date:\n", i + 1);
            System.out.print("Color (RED/BLUE/BLACK): ");
            Color color = Color.valueOf(sc.next());

            System.out.print("retangle or circle (r/c): ");
            char geometricForm = sc.next().toUpperCase().charAt(0);

            if (geometricForm == 'r') {
                System.out.print("widgth: ");
                Double widgth = sc.nextDouble();

                System.out.print("height: ");
                Double height = sc.nextDouble();
                shapes.add(new Retangule(height, widgth, color));
            }
            else if (geometricForm == 'c') {
                System.out.print("radius: ");
                Double radius = sc.nextDouble();

                shapes.add(new Circle(color, radius));
            }
            else {
                System.out.print("opcao invalida");
            }
        }
        sc.close();

        System.out.print("SHAPES AREA:");

        for (Shape s : shapes) {
            System.out.println(s.area());
        }
    }
}
