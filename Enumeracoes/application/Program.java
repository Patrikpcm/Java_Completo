/*
 *          Enumerações
 * - É um tipo especial que serve para especificar de forma literal um conjunto de constantes relacionadas
 * - Palavra chave em Java: enum
 * - Vantagem: Melhor semântica, código mais legível e auxiliado pelo compilador
 */


package Enumeracoes.application;
import java.util.Date;
import Enumeracoes.entities.Order;
import Enumeracoes.enums.OrderStatus;

public class Program {
    public static void main(String[] args) {
        
        Order order = new Order(10, new Date(), OrderStatus.PENDING_PAYMENT);
        System.out.println(order);    

        /*
         * Conversão de String para enum
         * 
         * OrderStatus os1 = OrderStatus.DELIVERED;
         * OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
         */

         OrderStatus os1 = OrderStatus.DELIVERED;
         OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
         System.out.println(os1);
         System.out.println(os2);
    }
}
