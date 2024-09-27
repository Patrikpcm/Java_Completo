package Trabalhando_com_arquivos.Bloco_try_with_resourcers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Diferente da leitura com FileReader e BufferedReader
 * e da leitura com File e Scanner, o bloco try-with-resources
 * declara um ou mais recursos e GARANTE que esses serão
 * fechados ao final do bloco. Isso é bom pois evita que o 
 * programador fique se preocupando com esses detalhes.
 * Para utilizar esse recurso as declarações são realizadas
 * dentro da chamada do Try( ).
 *  
 * Esse recurso esta disponível a partir do Java 7.
 */

public class Program {
    public static void main(String[] args) {
        String path = "Trabalhando_com_arquivos/in.txt";

        //colocamos o BufferedReader e o FileReader direto no try
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            //Lê uma linha do arquivo. Se ele estiver no final, readLine retorna null
            String line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
