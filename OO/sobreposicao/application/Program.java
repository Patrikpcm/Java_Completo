package OO.sobreposicao.application;

import OO.sobreposicao.entities.Account;
import OO.sobreposicao.entities.BusinessAccount;
import OO.sobreposicao.entities.SavingsAccount;


/*
 * PROBLEMA DA SOBREPOSIÇÃO: @Override
 * Suponhamos que a operação de saque possui uma taxa no valor de 5.0.
 * Entretanto, se a conta for do tipo poupança, esta taxa não deve ser
 * cobrada.
 * Como resolver?
 * Sobrescrevendo o método withdraw na subclasse SavingsAccount (Olhar as classes Account e SavingsAccount)
 * 
 * 
 * PALAVRA SUPER
 * É possível chamar a implementação da superclasse usando a palavra super.
 * Exemplo: Suponhamos que, na classe BusinessAccount, a regra para saque
 * seja realizar o saque normalmente da superclasse, e descontar mais 2.0
 * Para isso usamos SUPER, aproveitando a lógica a superclasse sem reescreve-la,
 * mas adicionando mais uma função de descontar 2.0 no balanço.
 * 
 * @Override
 * public void withdraw(double amount){
 *      super.withdraw(amount);
 *      balance -= 2.0;
 * }
 */

public class Program {
    public static void main(String[] args) {
        Account acc1 = new Account(1001, "Pedro", 1000.0);
        acc1.withdraw(200.0);
        System.out.println(acc1.getBalance());

        Account acc2 = new SavingsAccount(1002, "Luiz", 1000.0, 0.01);
        acc2.withdraw(200.0);
        System.out.println(acc2.getBalance());

        Account acc3 = new BusinessAccount(1003, "Cecilia", 1000.0, 500.0);
        acc3.withdraw(200.0);
        System.out.println(acc3.getBalance());
    }
}