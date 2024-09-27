package Trabalhando_com_arquivos.FileWriter_BufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter - Stream de escrita de caracteres em arquivos
 *  - Cria/Reescreve do zero o arquivo: new FileWriter(path)
 *  - Acrescenta ao arquivo existente:  new FileWriter(path, true)
 */

public class Program {
    public static void main(String[] args) {
        String[] lines = new String[] {"O rato roeu", "a roupa do rei", "de Roma.", "O rei não ficou nada feliz", "Coitado do rei...", "Coitado do rato..."};
        
        String path = "Trabalhando_com_arquivos/out.txt"; //caminho para salvar o arquivo

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){ //com o parâmetro True, ele não sobrescreve o arquivo
            for (String line : lines){
                bw.write(line);
                bw.newLine(); //quebra de linha
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage() );
        }
    }
}
