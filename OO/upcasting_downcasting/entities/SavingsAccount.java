package OO.upcasting_downcasting.entities;

public class SavingsAccount extends Account {
    private Double interestRate;

    public SavingsAccount(){
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance); //chamando a execução do construtor da superclasse
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
 
    public void updateBalance(){
        balance += balance*interestRate;
    }
}
