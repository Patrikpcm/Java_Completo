package Generics.Set.application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 *      SET<T>
 * - Representa um conjunto de elementos, similiar ao do Álgebra.
 * - Não admite repetições.
 * - Elementos não possuem posição (mas podem apresentar ordenação dependendo da implementação).
 * - Acesso, inserção e remoção de elementos são rápidos.
 * - Oferece operações eficientes de conjunto: intersecção, união, diferença.
 * - Principais implementações:
 *      - HashSet - Mais rápido (Operações O(1) em tabela hash) e não ordenado.
 *      - TreeSet - Mais lento (Operações O(log(n)) em árvores rubro-negra) e ordenado pelo 
 *                  compareTo do objeto (Ou Comparator).
 *      - LinkedHashSet - Velocidade intermediária e elementos na ordem em que são adicionados.
 * 
 *      MÉTODOS IMPORTANTES
 * - add(obj), remove(obj), contains(obj)
 *      - Baseado em equals e hashCode
 *      - Se equals e hashCode não existir, é usada comparação de ponteiros
 * - clear()
 * - size()
 * - removeIf(predicate)
 * - addAll(other) = união: adiciona no conjunto os elelementos do outro conjunto, sem repetição.
 * - retainAll(other) = interseção: remove do conjunto os elementos não contidos em other.
 * - removeAll(other) = diferença: remove do conjunto os elementos contidos em other.
 */

public class Program {
    public static void main(String[] args) {
        //Set<String> set = new HashSet<>(); //hashSet não garante a ordem
        //Set<String> set = new TreeSet<>(); //TreeSet garante a ordem, mas é mais lento
        Set<String> set = new LinkedHashSet<>();

        set.add("IV");
        set.add("Tablet");
        set.add("Notebook");
        set.add("Dinossauro");
        set.add("IP");
        set.add("Pipoca");
        set.add("Ana");
        set.add("Ana");
        set.add("PI");

        System.out.println(set.contains("Notebook"));

        set.remove("Tablet");
        set.removeIf(x -> x.charAt(0) == 'A'); //remove todo mundo que tem a primeira letra A
        set.removeIf(x -> x.length() > 3); //remove todo mundo que tem tamanho maior que 3 letras

        for (String string : set) {
            System.out.println(string);
        }

        System.out.println("\n---- OPERAÇÕES DE CONJUNTO ----\n");

        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,7,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));

        //union
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        //intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        //difference
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);
    
    
    }
}
