package Interfaces.Default_methods.services;

public class BrazilInterestService implements InterestService{
    private Double interestRate;

    public BrazilInterestService(double interestRate){
        this.interestRate = interestRate;
    }

    @Override
    public double getInterestRate() {
        return interestRate;
    }

}
