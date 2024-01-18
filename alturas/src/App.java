import java.util.Locale;
import java.util.Scanner;
import util.Pessoa;
public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("quantas pessoas vao ser cadastradas? ");
        int quant = sc.nextInt();

        Pessoa[] pessoas = new Pessoa[quant];

        for (int i = 0; i < quant; ++i) {
            System.out.print("name: ");
            String name = sc.nextLine();
            System.out.print("age: ");
            int age = sc.nextInt();
            System.out.print("heigth: ");
            double heigth = sc.nextDouble();
            pessoas[i] = new Pessoa(name, age, heigth);
        }
        sc.close();
        double mediaHeigth = 0;
        int under16 = 0;

        for (int i = 0; i < quant; ++i) {
            mediaHeigth = pessoas[i].getHeigth();
            if (pessoas[i].getAge() < 16) {
                under16 += 1;
            }
        }

        mediaHeigth = mediaHeigth / quant;
        double percentUnder16 = under16 / (float)quant;

        System.out.printf("altuara media: %f", mediaHeigth);
        System.out.printf("Pessoas menores de 16 anos: %.2f%", percentUnder16);

    }
}
