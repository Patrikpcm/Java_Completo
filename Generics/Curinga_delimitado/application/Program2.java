package Generics.Curinga_delimitado.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * *Pai de todos os tipos-                                                       Object
                                                            ______________________|______________
                                                           |                |                    |
 *Os 3 são filhos de Object-                             Number      Boolean(boolean)     Character(char)
                                    _______________________|__________________________________________________
                                    |           |               |               |           |                |
 *Filhos de Number-             Byte(byte)  Short(short)    Integer(int)    Long(long)  Float(float)    Double(double)
 * 
 */
public class Program2 {
    public static void main(String[] args) {
        /* Princípio get/put - COVARIÂNCIA */
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(5);
        //Posso executar essa operação pois Integer é um subtipo mais específico de Number
        List<? extends Number> list = intList; 
        Number x = list.get(0);
        //Não posso executar essa operação pois não sei de que subtipo é a lista.
        //list.add(20.1); //pode ser que a lista seja de Byte e eu estou tentando add um double.

        /*Princípio get/put - CONTRAVARIÂNCIA */
        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");
        /*posso executar essa operação pois a lista recebe não só o tipo Number como qualquer
         outro Supertipo dele. */
        List<? super Number> myNums = myObjs;
        myNums.add(10);
        myNums.add(3.14); //não gera erro de compilação

        /*Não posso atribuir um valor a uma variável Number. Pois não sei qual o tipo de dado
        a lista ira retornar.*/
        //Number x = myNums.get(0); 
        
        /*
        * PROBLEMA 2 - Principio get/put
        * Fazer um método que copia os elementos de uma lista para outra lista que pode ser mais 
        * genérica que a primeira.
        */
         List<Integer> myInts = Arrays.asList(1,2,3,4);
         List<Double> myDoubles = Arrays.asList(3.14, 6.28);
         List<Object> myObjcts = new ArrayList<Object>();
         
         copy(myInts, myObjcts);
         printList(myObjcts);
         copy(myDoubles, myObjcts);
         printList(myObjcts);
    }

    //Lista de origem é de qualquer tipo que extends Number (covariância)
    //Lista de destino é de qualquer tipo que pode ser SuperTipo de Number (Contravariância)
    public static void copy(List<? extends Number> source, List<? super Number> destiny){
        for(Number number: source){
            destiny.add(number);
        }
    }

    public static void printList(List<?> list){
        for (Object obj: list){
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
