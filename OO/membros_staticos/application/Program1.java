/*
 * Nesse exemplo, todos métodos estão na pŕopria classe do programa. 
 * Obs: dentro de um método estático você não pode chamar membros de instância da mesma classe.
 */

package OO.membros_staticos.application;
import java.util.Locale;
import java.util.Scanner;

public class Program1 {

    public static final double PI = 3.141592; //A palavra final define que o valor é constante e não pode ser mudado.
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double c = circumference(radius);

        double v = volume(radius);

        System.out.printf("Circunference: %.2f%n", c);
        System.out.printf("Volume: %.2f%n", v);
        System.out.printf("PI value: %.2f%n", PI);

        sc.close();
    }

    public static double circumference(double radius){
        return 2.0 * PI * radius;
    }

    public static double volume(double radius){
        return ( 4.0 * PI * radius * radius * radius ) / 3.0;
    }
}
