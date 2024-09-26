package OO.tratamento_excecoes.try_catch.application;

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
        Scanner sc = new Scanner(System.in);

        try{
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }
        //captura o erro caso o usuário digite uma posição que não existe no vetor
        catch(ArrayIndexOutOfBoundsException e){ 
            System.out.println("Invalid position");
        }
        //captura o erro caso o usuário digite uma letra em vez de um número
        catch(InputMismatchException e){
            System.out.println("Input error");
        }

        System.out.println("End of program");

        sc.close();
    }
}
