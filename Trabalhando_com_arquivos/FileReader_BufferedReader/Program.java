package Trabalhando_com_arquivos.FileReader_BufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * FileReader - Stream de leitura de caracteres a partir de arquivos
 * BufferedReader - Mais rápido
 * 
 * Esse código apenas exemplifica o passo a passo para abrir um arquivo na mão,
 * observando como é verboso e complexo. Existem outras formas de se trabalhar
 * a manipulação de arquivos.
 */
public class Program {
    public static void main(String[] args) {
        String path = "Trabalhando_com_arquivos/in.txt";
        FileReader fr = null;
        BufferedReader br = null;

        try{
            /* BufferedReader é instanciado a partir do FileReader
               ele é uma abstração maior. Com o BufferedReader conseguimos
               deixar a leitura mais rápida e flexível.*/
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            //br = new BufferedReader(fr = new FileReader(path)); a instanciação poderia ser dessa forma

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
        finally{
            try{    
                if(br != null)
                    br.close();
                
                if(fr != null)
                    fr.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

    }

}
