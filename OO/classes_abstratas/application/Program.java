package OO.classes_abstratas.application;

import java.util.List;
import java.util.ArrayList;
import OO.classes_abstratas.entities.Account;
import OO.classes_abstratas.entities.SavingsAccount;
import OO.classes_abstratas.entities.BusinessAccount;

/*
 *  CLASSES ABSTRATAS
 * - São classes que não podem ser instanciadas.
 * - É uma forma de garantir herança total: somente subclasses não abstratas podem ser
 *   instanciadas, mas nunca a superclasse abstrata;
 * 
 *  EXEMPLO
 * - Suponha que em um negócio relacionado a banco, apenas contas poupança e contas para
 *   empresas são permitidas (SavingsAccount e BusinessAccount). NÃO EXISTE conta comum.
 *
 * - Para garantir que contas comuns não possam ser instanciadas, basta acrescentarmos 
 *   a palavra 'abstract' na declaração da classe.
 */

public class Program {
    public static void main(String[] args) {
        //Account acc1 = new Account(1020, "Pedro", 1000.0); //Gera erro pois account é abstrata      
        Account acc2 = new SavingsAccount(1021, "Maria", 1000.0, 0.01);
        Account acc3 = new BusinessAccount(1022, "Alex", 1000.0, 500.0);
     

        List<Account> list = new ArrayList<>();
        list.add(new SavingsAccount(1001,"Pedro", 500.0, 0.01));
        list.add(new BusinessAccount(1002,"Luiz", 1000.0, 500.0));
        list.add(new SavingsAccount(1003,"Maria", 300.0, 0.01));
        list.add(new BusinessAccount(1004,"Cecília", 800.0, 500.0));

        double sum = 0.0;
        for (Account account : list) {
            sum += account.getBalance(); //somando total das contas
            account.deposit(10.0); //aproveitando foreach para adicionar 10.0 em cada conta
        }
        System.out.println("Total nas contas: R$"+sum);

        for (Account account : list) {
            System.out.printf("conta %d, R$%.2f\n", account.getNumber(), account.getBalance());
        }

    }
    /**
     * MOTIVOS PARA USAR CLASSES ABSTRATAS
     *  - Reuso de código
     *  - Polimorfismo: A superclasse classe genérica nos permite tratar de forma fácil e uniforme todos
     *                  os tipos de conta, inclusive com polimorfismo se for o caso. Pode-se colocar todos
     *                  os tipos de contas em uma mesma coleção.
     *                  Ex: Digamos que queremos totalizar o saldo de todas as contas;
     *                      Adicionar 10.0 ao saldo de todas as contas.
     */
}