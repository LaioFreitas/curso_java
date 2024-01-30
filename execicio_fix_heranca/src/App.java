import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
// import java.util.Date;
import entites.*;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the number of  products: ");
        int numberOfProducts = sc.nextInt();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < numberOfProducts; ++i) {
            System.out.printf("product #%d data:\n", i + 1);
            System.out.print("common, used or imported (c/u/i)? ");
            char categoryOfProduct = sc.next().toUpperCase().charAt(0);

            System.out.print("name: ");
            String name = sc.nextLine();

            System.out.print("price: ");
            Double price = sc.nextDouble();

            if (categoryOfProduct == 'C') {
                products.add(new Product(name, price));
            }
            else if (categoryOfProduct == 'I') {
                System.out.print("customs fee: ");
                Double customsFee = sc.nextDouble();

                products.add(new ImportedProduct(name, price, customsFee));
            }    
            else if (categoryOfProduct == 'U'){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                System.out.print("Monofacture date (dd/MM/yyyy): ");
                // Date monofactureDate = sdf.parse(sc.next());

                products.add(new UsedProduct(name, price, sdf.parse(sc.next())));
            }
            else {
                System.out.println("opcao invalida");
            }
        }
        sc.close();

        System.out.println("PRICE TAGS:");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }
    }
}
