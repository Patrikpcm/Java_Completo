package OO.tratamento_excecoes.excecoes_personalizadas.solucao_ruim.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import OO.tratamento_excecoes.excecoes_personalizadas.solucao_ruim.entities.Reservation;

import java.util.Date;

/**
 * Essa solução é dada como ruim e diferente da muito ruim é todas as validações serão
 * realizadas dentro da classe de reserva, a qual irá retornar uma string.
 * 
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


        if(!checkOut.after(checkIn)){
            /*Essa validação ainda tem que ser executada no programa principal
              pois para trata-la teriamos que colocar a validação dentro do construtor
              e não há como fazer o mesmo retornar uma string.*/
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: "+reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());
            
            String error = reservation.updateDates(checkIn, checkOut);
            if(error != null){
                System.out.println("Error in reservation: "+error);
            }
            else{
                System.out.println("Reservation: "+reservation);
            }
    
        }
        sc.close();
    }

}
