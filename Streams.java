import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*      STREAM
 * 
 * - É uma sequencia de elementos advinda de uma fonte de dados que oferece suporte
 *   a "operações agregadas".
 *     - Fonte de dados: coleção, array, função de iteração, recurso de E/S.
 * 
 *  
 *      Características
 * 
 * - Stream é uma solução para processar sequências de dados de forma:
 *      - Declarativa (iteração interna: escondida do programador)
 *      - Parallel-Friendly (imutável->thread safe)
 *      - Sem efeitos colaterais
 *      - Sob demanda (lazy evaluation)
 * - Acesso sequencial (NÃO HÁ ÍNDICES)
 * - Single-use: Só pode ser "usada" uma vez
 * - Pipeline: Operações em streams retornam novas streams. Então é possível criar uma cadeira
 *             de operações (fluxo de processamento).
 * 
 * 
 *      Operações Intermediárias e Terminais
 * 
 * - O pipeline é composto por zero ou mais operações intermediárias e uma terminal
 * - Operação intermediária:
 *      - Produz uma nova stream (encadeamento)
 *      - Só executa quando uma operação terminal é invocada (lazy evaluation)
 * - Operação terminal
 *      - Produz um objeto não-stream (coleção ou outro)
 *      - Determina o fim do processamento da stream
 * 
 * 
 *      Operações Intermediárias
 * 
 *  - filter, map, flatmap, peek, distinct, sorted, skip, limit(*)
 * 
 * 
 *      Operações Terminais
 *
 *  - forEach, forEachOrdered, toArray, reduce, collect, min, max, count, anyMath(*), allMatch(*),
 *   noneMatch(*), findFirst(*), findAny(*)
 * 
 * 
 *      Como criar uma stream
 * - Basta chamar o método stream() ou parallelStream() a partir de qualquer objeto Collection.
 *      - parallelStream habilita a execução do código de forma paralela pelo java automaticamente.
 * - Outras formas de se criar uma stream incluem:
 *      -Stream.of,  Stream.ofNullable,  Stream.iterate
 */

public class Streams{
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> st1 = list.stream();
        System.out.println(Arrays.toString(st1.toArray()));

        st1 = list.stream().map(x -> x*10); //multiplicando cada elemento por 10 com map
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("Maria", "Pedro", "Irene"); //criando stream com Stream.of
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0, x->x+2); //criando uma stream onde o primeiro elemento(x) é zero e os demais são x+2
        System.out.println(Arrays.toString(st3.limit(10).toArray())); //imprimindo 10 valores

        // Criando sequência de Fibonacci
        Stream<Long> st4 = Stream.iterate(new Long[]{0L, 1L}, p -> new Long[]{p[1], p[0]+p[1]}).map(p->p[0]);
        System.out.println(Arrays.toString(st4.limit(20).toArray()));
    }
}