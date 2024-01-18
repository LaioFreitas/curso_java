import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quantos valores vai ter o vetor?");
        int n = sc.nextInt();

        int[] vect = new int[n];

        for (int i = 0; i < n; ++i) {
            System.out.print("digite um valor: ");
            vect[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("Numeros negativos:");

        for (int i = 0; i < n; ++i) {
            if (vect[i] < 0) {
                System.out.println(vect[i]);
            }
        }
    }
}
