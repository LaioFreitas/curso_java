import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
    
            System.out.println(vect[position]);

        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("invalide position");
        } 
        catch(InputMismatchException e) {
            System.out.println("input error");
        }

        System.out.println("end of program");

        sc.close();
    }
}
