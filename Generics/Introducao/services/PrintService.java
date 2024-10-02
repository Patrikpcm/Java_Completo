package Generics.Introducao.services;
import java.util.ArrayList;
import java.util.List;

/*
 * ESSE SERVIÇO DE IMPRESSÃO FUNCIONA PARA INTEGERS, MAS SE EU QUISESSE
 * REUTILIZA-LO PARA IMPRIMIR OUTROS OBJECTS? COMO POR EXEMPLO STRINGS?
 * PROBLEMA DO REUSO.
 * Solução: 
 *  - Crio um segundo serviço de impressão para Strings. (RUIM, pois vou repetir código);
 *  - Implementar o PrintService com object em vez de valores primitivos.
 *  - Utilizo GENERICS. (BOM)

public class PrintService {
    List<Integer> list = new ArrayList<>();

    public void addValue(Integer value){
        list.add(value);
    }

    public Integer first(){
        if(list.isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }

    public void print(){
        System.out.print("[");
        if(!list.isEmpty()){
            System.out.println(list.get(0));
        }
        for(int i=1; i<list.size(); i++){
            System.out.println(", " + list.get(i));
        }
        System.out.println("]");
    }
}
*/

/* ESSA IMPLEMENTAÇÃO É COM OBJECT. NÃO FUNCIONA POIS NÃO CONSEGUIMOS CONTROLAR 
 * O TYPE SAFETY.
 * Ou seja, se por algum motivo o usuário quiser misturar Integers e Strings na 
 * lista, ele irá conseguir, mas na hora da impressão o programa irá quebrar.


public class PrintService {
    List<Object> list = new ArrayList<>();

    public void addValue(Object value){
        list.add(value);
    }

    public Object first(){
        if(list.isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }

    public void print(){
        System.out.print("[");
        if(!list.isEmpty()){
            System.out.println(list.get(0));
        }
        for(int i=1; i<list.size(); i++){
            System.out.println(", " + list.get(i));
        }
        System.out.println("]");
    }
}
*/

/**
 * BOA SOLUÇÃO - USANDO GENERICS
 * Vai garantir o typesafe, reuso e evitar problemas com 
 * performance (execução de cast e boxing/unboxing).
 */

public class PrintService<T>{ //classe parametrizada com um certo tipo <T>
    List<T> list = new ArrayList<>();

    public void addValue(T value){
        list.add(value);
    }

    public T first(){
        if(list.isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }

    public void print(){
        System.out.print("[");
        if(!list.isEmpty()){
            System.out.println(list.get(0));
        }
        for(int i=1; i<list.size(); i++){
            System.out.println(", " + list.get(i));
        }
        System.out.println("]");
    }
}