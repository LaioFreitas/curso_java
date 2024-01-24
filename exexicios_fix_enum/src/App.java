import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;
import entities.Client;
import entities.Order;
import entities.enums.OrderStatus;
import entities.OrderItem;
import entities.Product;
public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("enter client data:");
        System.out.print("name: ");
        String name = sc.nextLine();

        System.out.print("email: ");
        String email = sc.next();

        System.out.print("birth date: ");
        Date birthDate = sdf.parse(sc.next());
        Client client = new Client(name, email, birthDate);

        System.out.println("enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        System.out.print("how many itens to this order? ");
        int quantityOrders = sc.nextInt();
        Order order = new Order(new Date(System.currentTimeMillis()), status);
        
        for (int i = 0; i < quantityOrders; ++i) {
            System.out.printf("enter #%d intem data:\n", i + 1);
            System.out.print("product name: ");
            
            System.out.print("product Price: ");
            Double productPrice = sc.nextDouble();
            
            Product productName = new Product(sc.nextLine(), );
            System.out.print("quantity: ");
            int productQuantity = sc.nextInt();

            OrderItem item = new OrderItem(productQuantity, productPrice,  );


        }
        
    }
}