package Generics.Map.application;

import java.util.Map;
import java.util.TreeMap;

/**
 *      MAP<K,V>
 * - É uma coleção de pares chave/valor.
 *      - Não admite repetições do objeto chave.
 *      - Os elementos são indexados pelo objeto chave(não possuem posição).
 *      - Acesso, inserção e remoção de elementos são rápidos.
 * - Uso comum: cookies, local storage, qualquer modelo chave-valor.
 * - Principais implementações:
 *      - HashMap - Mais rápido(operações O(1) em tabela hash) e não ordenado.
 *      - TreeMap - Mais lento (operações O(log(n)) em árvore rubro-negra) e ordenação pelo 
 *                  compareTo do objeto(ou Comparator).
 *      - LinkedHashMap - Velocidade intermediária e elementos na ordem em que são adicionados.
 */
public class Program {
    public static void main(String[] args) {
        
        Map<String, String> cookies = new TreeMap<>(); //treemap ordena pela chave

        cookies.put("username", "Maria");
        cookies.put("email","maria@gmail.com");
        cookies.put("phone", "999999999");

        cookies.remove("phone");

        System.out.println("ALL COOKIES: ");
        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }

        cookies.put("phone", "999999999");
        cookies.put("phone", "888888888"); //é adicionado um novo valor, mas não uma nova chave.

        System.out.println("\nALL COOKIES: ");
        for (String key : cookies.keySet()) {
            System.out.println(key + ": " + cookies.get(key));
        }

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone number: " + cookies.get("phone"));
        
        cookies.remove("email");
        System.out.println("Email: " + cookies.get("email")); //tentando acessar um valor que não existe
        System.out.println("Size: " + cookies.size());
    }    
}
