package OO.upcasting_downcasting.application;

import OO.upcasting_downcasting.entities.Account;
import OO.upcasting_downcasting.entities.BusinessAccount;
import OO.upcasting_downcasting.entities.SavingsAccount;

public class Program {
    public static void main(String[] args) {
        Account acc = new Account(1001, "Luiz", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Pedro", 0.0, 500.0);

        //UPCASTING - Atribuir um objeto especifico a um objeto mais genérico (um BusinessAccount e atribuir a um Account)
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "bob", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Cecilia", 0.0, 0.01);

        //DOWNCASTING - Converter um Objeto da superclasse para a subclasse

        
        //BusinessAccount acc4 = acc2;  /*erro, não posso converter Account para BusinessAccount*/
        BusinessAccount acc4 = (BusinessAccount)acc2; //para realizar essa conversão, preciso forçar utilizando um casting
        acc4.loan(100.0);

        //BusinessAccount acc5 = (BusinessAccount)acc3;  
                                                        /*Essa conversão só dara erro na hora da execução
                                                            pois o compilador não sabe que SavingsAccount é 
                                                            uma subclasse de Account.
                                                            Explicação: - BusinessAccount É UMA Account.
                                                                        - SavingsAccount É UMA Account.
                                                                        - Porém, BusinessAccount não é 
                                                                          uma SavingsAccount e vice-versa.
                                                        */
        //Para tentarmos a conversão (casting) precisamos testar antes
        if(acc3 instanceof BusinessAccount){
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(200.0);
            System.out.println("Loan!");
        }

        if(acc3 instanceof SavingsAccount){
            SavingsAccount acc5 = (SavingsAccount)acc3; //acc3 é do tipo Account, por isso precisamos de cast
            acc5.updateBalance();
            System.out.println ("Update!");
        }
    }
}