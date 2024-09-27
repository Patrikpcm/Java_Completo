package Trabalhando_com_arquivos.Manipulando_pastas;

import java.util.Scanner;
import java.io.File;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        //ex: Trabalhando_com_arquivos/
        String strPath = sc.nextLine();

        File path = new File(strPath); //caminho das pastas

        /* A função isDirectory vai criar um vetor contento 
            todas as pastas contidas no caminho digitado*/
        File[] folders = path.listFiles(File::isDirectory);
        for (File file : folders) {
            System.out.println(file);
        }

        System.out.println();

        /*isFile imprime os arquivos contidos no caminho */
        File[] arquivos = path.listFiles(File::isFile);
        for (File arquivo : arquivos) {
            System.out.println(arquivo);
        }

        //criando um diretório
        boolean success = new File(strPath + "/pasta_exemplo").mkdir();
        System.out.println("Directory created successfully: " + success);
        

        sc.close();
    }
}
