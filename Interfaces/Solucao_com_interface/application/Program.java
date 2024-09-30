package Interfaces.Solucao_com_interface.application;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Interfaces.Solucao_com_interface.model.entities.CarRental;
import Interfaces.Solucao_com_interface.model.entities.Vehicle;
import Interfaces.Solucao_com_interface.model.services.BrazilTaxService;
import Interfaces.Solucao_com_interface.model.services.RentalService;

public class Program { 
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Entre com o preço por hora: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Entre com o preço por dia: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay,
                                                        pricePerHour,
                                                        new BrazilTaxService());
        /* Aqui temos um upcastin da classe BrazilTaxSerice que é um subtipo da classe
         TaxService. Caso o serviço de taxas mude no futuro, o único ponto a ser modificado
         em todo o programa será aqui, não precisando mexer nas demais classes. */

        rentalService.processInvoice(cr);

        System.out.println("FATURA:");
        System.out.println("Pagamento básico: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Pagamento total: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));

        sc.close();
    }
    
}
