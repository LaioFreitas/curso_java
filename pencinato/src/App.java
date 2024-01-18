import java.util.Locale;
import java.util.Scanner;
import util.Studant;
public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("how many rooms will be rented? ");
        int quantRoom = sc.nextInt();
        Studant[] rooms = new Studant[quantRoom]; 
        
        for (int i = 0; i < quantRoom; ++i) {
            System.out.printf("rent #%d", i + 1);
            System.out.print("name: ");
            String name = sc.nextLine();
            
            System.out.print("Email: ");
            String email = sc.next();

            System.out.print("room: ");
            int room = sc.nextInt();

            rooms[room] = new Studant(name, email, room);
        }
        sc.close();

        System.out.println("busy rooms: ");

        for (int i = 0; i < quantRoom; ++i) {
            if (rooms[i] != null) {
               rooms[i].toString(); 
            }
        }

    }
}
