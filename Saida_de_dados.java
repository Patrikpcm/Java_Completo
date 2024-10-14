import java.util.Locale;

public class Saida_de_dados {
    public static void main(String[] args){
        int y = 32;
        double x = 3.14159234;
        String nome = "Tenório";

        System.out.println(nome);
        System.out.println(y);
        System.out.println(x); 
        System.out.printf("%.2f%n", x); //saída formatada, mas o separador é uma vírgula por motívos de linguagem pt-br.
        System.out.printf("%.4f%n", x); //saída formatada, mas o separador é uma vírgula.
        Locale.setDefault(Locale.US); //configurando para o idioma inglês para o separador ser um ponto.
        System.out.printf("%.4f%n", x); //separador com ponto, depois de definir o locale.US (linguagem US)
        System.out.println("Resultado = " + (x + y) + " Metros"); //concatenando COM SOMA
        System.out.println("Resultado = " + x + y + " Metros"); //concatenando SEM SOMAR

        //usando PRINTF
        /*
         * %f - Ponto flutuante
         * %d - Inteiro
         * %s - String
         * %n ou \n - quebra de linha 
         */
        System.out.printf("Resultado = %.2f metros. Angulo de %d graus! %n \n", x, y);
    }
}
