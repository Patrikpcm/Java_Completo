package Trabalhando_com_arquivos.Lendo_arquivos_com_File_e_Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        
        File file = new File ("Trabalhando_com_arquivos/in.txt");
        Scanner sc = null;
        /*Temos que executar a abertura de um arquivo dentro do try porque o compilador
          o File lança uma exceção IoException*/
        try{ 
            sc = new Scanner(file);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch(IOException e){
           System.out.println( e.getMessage() );
        }
        finally{
            /*Precisamos testar se sc é diferente de nulo pois pode haver um erro
              no momento de instanciar o  */
            if(sc != null){
                sc.close();
            }
        }
    }
}
