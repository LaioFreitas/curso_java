import java.util.Date;
import entities.Order;
import entities.enums.OrderStatus;

public class App {
    public static void main(String[] args) throws Exception {
        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);

        System.out.println(order.toString());

        // string para enum

        OrderStatus a1 = OrderStatus.valueOf("DELIVERED");
        OrderStatus a2 = OrderStatus.PROCESSING;

        System.out.println(a1);
        System.out.println(a2);
    }
}
