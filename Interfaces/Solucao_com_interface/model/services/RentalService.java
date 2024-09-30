package Interfaces.Solucao_com_interface.model.services;

import java.time.Duration;

import Interfaces.Solucao_com_interface.model.entities.CarRental;
import Interfaces.Solucao_com_interface.model.entities.Invoice;

public class RentalService {
    private Double pricePerDay;
    private Double pricePerHour;    
    private TaxService taxService;
   
    /**
     * Com a utilização de interface, desacoplamos o serviço de TaxService associado ao
     * Brasil, dessa forma a classe esta fechada para modificações futuras, já que em nenhum
     * ponto é citado o BrazilTaxService, somente TaxService a qual é uma interface.
     */


    public RentalService(Double pricePerDay, Double pricePerHour, TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }
    
    public void processInvoice(CarRental carRental){
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;

        double basicPayment;
        if(hours <= 12.0)
            basicPayment = pricePerHour * Math.ceil(hours);
        else
            basicPayment = pricePerDay * Math.ceil(hours / 24.0);
        
        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
