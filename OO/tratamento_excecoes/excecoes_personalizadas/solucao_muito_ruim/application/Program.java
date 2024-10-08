package OO.tratamento_excecoes.excecoes_personalizadas.solucao_muito_ruim.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import OO.tratamento_excecoes.excecoes_personalizadas.solucao_muito_ruim.entities.Reservation;

import java.util.Date;

/**
 * Essa solução é dada como muito ruim pois toda as questões de validação são realizadas
 * dentro do programa principal. Quando na verdade essas lógicas deveriam estar dentro
 * da própria reserva. É um problema muito sério de delegação, pois quem deveria saber 
 * sobre reservas é a própria reserva, e não outras classes.
 */

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn))
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: "+reservation);

            System.out.println();

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else if(!checkOut.after(checkIn)){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else{
                reservation.updateDates(checkIn, checkOut);
                System.out.println(reservation);
            }
        }
        sc.close();
    }

}
