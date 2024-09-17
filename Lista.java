/*
 *  - Tamanho da lista: size()
 *  - Inserir elemento na lista: add(obj), add(int, obj)
 *  - Remover elementos da lista: remove(obj), remove(int), removeIf(Predicate)
 *  - Encontrar posição de elemento: indexOf(obj), lastIndexOf(obj)
 *  - Filtrar lista com base em predicado: list<Integer> result = list.stream().filter(x -> x > 4).collect(Collectors.toList());
 *  - Encontrar primeira ocorrência com base em predicado: Integer result = list.stream().filter(x -> x >4).findFirst().orElse(null);
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Lista {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
       
        List<String> list = new ArrayList<>();

        list.add("Maria");
        list.add("Pedro");
        list.add("Luiz");
        list.add("Cecília");
        list.add(2, "Pedro Luiz");

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("--------------------");

        System.out.println(list.size());
        list.remove("Pedro Luiz");
        System.out.println(list.size());

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("--------------------");

        list.removeIf(x -> x.charAt(0) == 'M'); //remoção por predicado, remove todos cuja letra na posição 0 seja M
                                                //Faz a operação utilizando uma função lambda

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("--------------------");

        System.out.println("Index of Pedro: "+ list.indexOf("Pedro") );
        
        System.out.println("--------------------");
        
        list.add("Anna");
        list.add("Amalia");
        list.add("Airton");
        list.add("Ari");
        list.add("Ronaldo");
        list.add("Ricardo");
        list.add("Robson");
        list.add("Renan");
        list.add("Lucas");
        list.add("Zelia");
        list.add("Xuxa");
        list.add("Gustavo");

        //filtrando a lista só com as pessoas que começam com A
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
                                //stream aceita lambda                      Collectors converte o tipo stream pra lista novamente
    
        for (String string : result) {
            System.out.println(string);
        }

        System.out.println("--------------------");

        //Recuperando o primeiro elemento que atende o predicado. Se não encontrar retorna nulo
        String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
        System.out.println(name);

        //retorna null pois não há ninguém com j
        name = list.stream().filter(x -> x.charAt(0) == 'j').findFirst().orElse(null);
        System.out.println(name);

        //retorna null porque a função é keysensitive
        name = list.stream().filter(x -> x.charAt(0) == 'r').findFirst().orElse(null);
        System.out.println(name);
    }       
}
