package Interfaces.Solucao_sem_interface.model.services;

import java.time.Duration;

import Interfaces.Solucao_sem_interface.model.entities.CarRental;
import Interfaces.Solucao_sem_interface.model.entities.Invoice;

public class RentalService {
    private Double pricePerDay;
    private Double pricePerHour;
    private BrazilTaxService taxService;

    /*
     * O problema de não utilizar interfaces esta exemplificado acima, já que temos um alto 
     * acoplamento(dependencia) do serviço BrazilTaxService e o RentalService.
     * Nosso programa de aluguel de carro funciona única e exclusivamente para o serviço
     * de taxas brasileiro, não podendo ser aplicado para outros paíse, por exemplo.
     * 
     * Além disso, isso não é uma boa prática, já que temos 2 pontos de alteração caso o
     * negócio mude futuramente. Em termos de manutenção, esse código esta ruim.
     * Esses pontos são: 1 - Chamada da função no programa principal, na hora de instanciarmos
     *                      o serviço de aluguel.
     *                   2 - Alteração do serviço de imposto aqui dentro da classe, mudando de
     *                      BrazilTaxService para EUATaxService, por exemplo.
     */
   
    public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxService taxService) {
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
