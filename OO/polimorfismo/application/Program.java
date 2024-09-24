package OO.polimorfismo.application;


import OO.polimorfismo.entities.SavingsAccount;
import OO.polimorfismo.entities.Account;


/*
 *  POLIMORFISMO
 * Em programação OO, polimorfismo é o recurso que permite que variáveis de um mesmo tipo mais
 * genérico possam apontar para objetos de tipos específicos diferentes, tendo assim comportamentos
 * diferentes conforme cada tipo específico.
 * Ex:
 * Account x = new Account(1020, "Alex", 1000.0);
 * Account y = new SavingsAccount(1021, "Maria", 1000.0, 0.01);
 * 
 */

public class Program {
    public static void main(String[] args) {
        Account x = new Account(1020, "Alex", 1000.0);
        Account y = new SavingsAccount(1021, "Maria", 1000.0, 0.01);

        x.withdraw(50.0);
        y.withdraw(50.0); 
        //lembrando que withdraw em SavingsAccount esta sobrescrito @Override

        System.out.println(x.getBalance()); //945.0
        System.out.println(y.getBalance()); //950.0
    }

    /*
     *  Imporante entender
     * - A associação do tipo específico com o tipo genérico é feita em tempo de execução (upcasting).
     * - O compilador não sabe para qual tipo específico a chamada do método withdraw está sendo feita,
     *   ele só sabe que são duas variáveis tipo Account.
     */
}