import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();

        System.out.print("check-in date (dd/MM/yyyy)");
        Date checkIn = sdf.parse(sc.next());
    }
}
