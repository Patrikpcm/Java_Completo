package OO.heranca.entities;

public class BusinessAccount extends Account{

    private Double loanLimit;

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance); //passando as informações para o construtor da Account
        this.loanLimit = loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }
    public Double getLoanLimit() {
        return loanLimit;
    }

    public void loan(double amount){
        if (amount <= loanLimit){ //se o valor for menor igual ao meu limite de empréstimo, executo
            deposit(amount);
            balance += amount - 10.0; 
            /*Para realizarmos a cobrança dessa taxa(10 em cima de balance), o membro balance da classe
            Account deve ser protected, já que se deixassemos ele como private, somente a própria
            classe teria acesso e as subclasses não.
            */
        }
    }

}
