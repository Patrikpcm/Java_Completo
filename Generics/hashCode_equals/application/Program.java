package Generics.hashCode_equals.application;

import Generics.hashCode_equals.entities.Client;
/**
 *      hashCode e Equals
 *  - São operações da classe Object utilizadas para comparar se um objeto é igual a outro
 *      - equals: lento, resposta 100%
 *      - hashCode: rápido, porém resposta positiva não é 100%
 * 
 *  - Tipos comuns (String, Date, Integer, Double, etc) já possuem implementação para essas
 *    operações. Classes personalizadas precisam sobrepô-las.
 * 
 *      Regra de ouro do HashCode
 *  - Se o hashCode de dois objetos é diferente, então os objetos SÃO diferentes.
 *  - Se o código de dois objetos for igual, muito provavelmente os objetos são
 *    iguais (pode haver colisão).
 *  - Mas então, porquê usar hashCode? Digamos que temos que analisar igualdade
 *    de objetos numa lista muito grande, por ser mais rápido preferencialmente
 *    utilizaremos o hashCode. Caso dê compatibilidade de objetos, utilizamos a
 *    operação equals para validar a saída. 
 *    Basicamente o motivo é a velocidade com que ele avalia a igualdade.
 */
public class Program {
    public static void main(String[] args) {
        String a = "Maria";
        String b = "João";
        String c = "maria";
        String d = "Maria";
        System.out.println(a.equals(b)); //false, a != b
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        /*
         * Por que hashCode não é 100%? 
         * Número inteiro é limitado a 32bits, por isso pode acontecer de ter objetos
         * diferentes resultarem num mesmo hashCode. Mas isso é mera coincidência e
         * tem uma probabilidade baixíssima de acontecer, pois nos números inteiros
         * cabem mais de 4 bilhões de possibilidades.
         */

        //Override em hashCode e equals
        System.out.println("-------- EQUALS e HASHCODE Override ---------");
        Client c1 = new Client("Maria", "maria@maria.com");
        Client c2 = new Client("Jao", "jao@jao.com");
        Client c3 = new Client("Maria", "celina@123.com");
        Client c4 = new Client("Maria", "maria@maria.com");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c1.equals(c4));
        System.out.println(c1 == c4); //da false porque essa comparação utiliza posições de memória

        System.out.println("---- tratamento especial ----");
        String s1 = "test";
        String s2 = "test";
        /*Essa igualdade retorna true pois o compilador trata variáveis literais
        de maneira especial, guardando dados que são iguais no mesmo espaço de memória... 
        até que sejam diferentes.*/
        System.out.println(s1 == s2);
        /*Diferente de alocação de memória, onde cada variável terá seu espaço.*/
        String s3 = new String("test");
        String s4 = new String("test");
        System.out.println(s3 == s4);
    }
}
