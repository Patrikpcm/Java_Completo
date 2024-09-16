/*
 * Formatar - toLowerCase(), toUpperCase(), trim() "Trim serve para remover espaços"
 * Recortar - substring(inicio), substring(inicio,fim)
 * Substituir - Replace(char, char), Replace(string, string)
 * Buscar - IndexOf, LastIndexOf
 * str.Split("") "Dividir a string com base num separador"
 */

public class funcoes_string {
    public static void main(String[] args) {
        String original = "abcde FGHIJ ABC abc DEFG";

        String modificada = original.toLowerCase();
        System.out.println("Original: " + original);
        System.out.println("toLowerCase: " + modificada);
        modificada = original.toUpperCase();
        System.out.println("toUpperCase: " + modificada);
        modificada = original.trim();
        System.out.println("trim: " + modificada);
        modificada = original.substring(2,8);
        System.out.println("substring(2,8): " + modificada);
        modificada = original.substring(5);
        System.out.println("substring(5): " + modificada);
        modificada = original.replace("ABC", "KLM");
        System.out.println("replace(ABC KLM): " + modificada);
        int i = original.indexOf("bc");
        System.out.printf("IndexOf - Primeira ocorrencia de 'bc': %d\n", i);
        int j = original.lastIndexOf("bc");
        System.out.printf("LastIndexOf - Última ocorrencia de 'bc': %d\n", j);
        String[] vect = original.split(" ");
        System.out.println("Split(\" \") : ");
        for (String string : vect) {
            System.out.println(string);
        }
    }
}
