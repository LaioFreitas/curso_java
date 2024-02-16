import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import model.entites.Reservation;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();

        System.out.print("check-in date (dd/MM/yyyy)");
        Date checkIn = sdf.parse(sc.next());

        System.out.print("check-out date (dd/MM/yyyy)");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("error in resevertion: checkOut date must be after ");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("reservation " + reservation);
            
            System.out.println();
            System.out.println("enter data update the resevation: ");
            System.out.print("check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("check-out date (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());
            
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("error in reservation: reservation dates for  update must be future");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("error in resevertion: checkOut date must be after ");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
            }
        }
        sc.close();
    }
}