package Trabalhando_com_arquivos.Informacoes_caminho_arquivo;

import java.util.Scanner;
import java.io.File;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a file path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        System.out.println("getName: "+path.getName()); //recupera somente o nome do arquivo
        System.out.println("getParent: "+path.getParent()); //recupera o caminho do arquivo (pasta pai)
        System.out.println("getPath: "+path.getPath()); //recupera todo o caminho

        //existem muitos outros gets dentro da biblioteca File.

        sc.close();
    }
}