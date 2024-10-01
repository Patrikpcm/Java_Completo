package Interfaces.Default_methods.services;

import java.security.InvalidParameterException;

public interface InterestService {
    //eu não posso implementar o default para o getInterestRate, pois o valor fica no objeto
    double getInterestRate();
    
    //implementação de um default method
    default double payment(double amount, int months){
        if (months < 1){
            throw new InvalidParameterException("Months must be greater than zero.");
        }

        return amount * Math.pow(1.0 + getInterestRate() / 100.0, months);
    }
}
