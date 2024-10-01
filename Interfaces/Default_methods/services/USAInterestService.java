package Interfaces.Default_methods.services;

public class USAInterestService implements InterestService {
    private Double interestRate;

    public USAInterestService(double interestRate){
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

}
