package OO.tratamento_excecoes.pilha_de_chamadas_de_metodos_StackTrace.application;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * ESTRUTURA TRY-CATCH
 * 
 * - Bloco try
 * Contém o código que representa a execução normal do trecho de código que pode acarretar em uma exceção
 * 
 * - Bloco catch
 *  Contém o código a ser executado caso uma exceção ocorra.
 *  Deve ser especificado o tipo da exceção a ser tratada (upcasting é permitido).
 * 
 * - Sintaxe
 *  try{
 *  }
 *  catch(ExceptionType e){
 *  }
 *  catch(ExceptionType e){
 *  }
 *  catch(ExceptionType e){
 *  }
 */

public class Program {
    public static void main(String[] args) {
        method1();
        System.out.println("End of program");
    }

    public static void method1(){
        System.out.println("***METHOD1 START***");
        method2();
        System.out.println("***METHOD1 END***");
    }

    public static void method2(){
        System.out.println("***METHOD2 START***");

        Scanner sc = new Scanner(System.in);
        
        try{
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }
        //captura o erro caso o usuário digite uma posição que não existe no vetor
        catch(ArrayIndexOutOfBoundsException e){ 
            System.out.println("Invalid position");
            e.printStackTrace(); //ira imprimir a pilha de chamadas(stack trace) 
        }
        //captura o erro caso o usuário digite uma letra em vez de um número
        catch(InputMismatchException e){
            System.out.println("Input error");
        }

        sc.close();
        System.out.println("***METHOD2 END***");
    }
}
