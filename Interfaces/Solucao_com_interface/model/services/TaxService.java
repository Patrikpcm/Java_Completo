package Interfaces.Solucao_com_interface.model.services;

public interface TaxService {
   double tax(double amount); 
   /* não precisa declarar public abstract pois toda interface 
      já presume que o método é publico e abstrato.
      public abstract double tax(double amount);*/
}
