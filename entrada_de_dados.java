import java.util.Locale;
import java.util.Scanner;

public class entrada_de_dados {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        //deve-se importar a biblioteca scanner
        Scanner sc = new Scanner(System.in); //Associando o objeto scanner ao teclado.in
        
        String s = sc.next(); //aguarda a digitação de uma string
        System.out.println(s);

        int i = sc.nextInt(); //aguarda a digitação de um int
        System.out.println(i);

        //para definir o separador como . deve-se usar o comando Locale.setDefault(Locale.US);
        //Deve-se importar o Locale
        double d = sc.nextDouble(); //aguarda a digitação de um double
        System.out.println(d);

        char c = sc.next().charAt(0); //aguarda a digitação de um char, irá pegar somente a primeira letra
        System.out.println(c);

        
        //Ler entrada de dados até quebra de linha
        /*
         * Esse nextLine() sozinho serve para consumir a quebra de linha pendente das 
         * entradas de dados anteriores, sem ele um espaço vazio seria lido automaticamente
         * pela primeira variável. Semelhante a limpeza de cache ou getchar() em C/C++
        */
        sc.nextLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();

        System.out.println("Dados digitados: ");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        sc.close(); //depois de usar as leituras devemos sempre fechar o objeto
    }
}
