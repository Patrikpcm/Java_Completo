package OO.classes_metodos_final.entities;
import OO.classes_metodos_final.entities.SavingsAccount;

public class SavingsAccountPlus extends SavingsAccount { //aqui já apresenta erro, informando que não pode ser subclasse
    
    @Override
    public void withdraw(double amount){ //final no método tb gerará erro, não pode ser reescrito
        balance -= amount + 2.0;
    }

}

/**
 * POR QUÊ UTILIZAR FINAL?
 * - Segurança: Dependendo das regras de negócio, as vezes é desejável garantir que uma classe
 *              não seja herdada, ou que um método não seja sobreposto. 
 *              Geralmente convém acrescentar FINAL em métodos sobrepostos, pois sobreposições
 *              múltiplas podem ser uma porta de entrada para inconsistências.
 * 
 * - Performace: Atributos de tipo de uma classe final são analisados de forma mais rápida em
 *               tempo de execução.
 *               Exemplo clássico: String
 */
