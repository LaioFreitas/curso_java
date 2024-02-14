import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import model.entites.Reservation;
import model.exception.DomainException;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        try {

            System.out.print("check-in date (dd/MM/yyyy)");
            Date checkIn = sdf.parse(sc.next());
    
            System.out.print("check-out date (dd/MM/yyyy)");
            Date checkOut = sdf.parse(sc.next());
    
       
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("reservation " + reservation);
        
            System.out.println();
            System.out.println("enter data update the resevation: ");
            System.out.print("check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("check-out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());
        
            reservation.updateDates(checkIn, checkOut);
        }
        catch (ParseException e) {
            System.out.println("invalide format date");
        }
        catch (DomainException e) {
            System.out.println("erro in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected exeption");
        }
        sc.close();
    }
}