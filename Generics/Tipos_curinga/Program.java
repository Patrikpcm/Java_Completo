package Generics.Tipos_curinga;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Object> myObjs = new ArrayList<Object>();
        List<Integer> myNumbers = new ArrayList<Integer>();
        //myObjs = myNumbers; //Erro de compilação
        /*
         * A lista de tipo Integer não é um subtipo de Object. Diferente dos tipos(objetos) em si.
         * Um objeto do tipo Integer é um subtipo de um objeto do tipo Object. Mas para listas,
         * isso não é verdade.
         */

         //O Super tipo para qualquer lista é List<?>. Esse é o tipo curinga
         List<?> myObjs2 = new ArrayList<Object>();
         List<Integer> myNumbers2 = new ArrayList<Integer>();
         myObjs2 = myNumbers2; //note que aqui não há erro de compilação.

        Integer inteiro = 0;
        Object objeto;
        objeto = inteiro; //esse procedimento é permitido.
    }
}
