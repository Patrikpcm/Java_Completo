package OO.tratamento_excecoes.bloco_finally.application;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
/**
 * Bloco Finally
 * - É um bloco que contém código a ser executado independentemente de ter ocorrido ou não uma exceção
 * - Exemplo: Fechar um arquivo, conexão de BD, ou outro recurso específico ao final do processamento.
 * 
 * Sintaxe
 * try{
 * }
 * catch(ExceptionType e){
 * }
 * finally{
 * }
 */
public class Program {
    public static void main(String[] args) {
        File file = new File("in.txt"); // OO/tratamento_excecoes/bloco_finally/application/in.txt
        Scanner sc = null;              

        try{
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error opening file: "+ e.getMessage());
        }
        finally{ //indiferente de ter lido o arquivo ou não, eu preciso fechar o scanner.
            if(sc != null){
                sc.close();
            }
            System.out.println("Bloco finally executado.");
        }
    }
}
