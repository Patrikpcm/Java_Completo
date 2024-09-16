/*
 * Nesse exemplo, separamos os membros de instância numa classe separada chamada Calculator3.
 * Todos os membros dessa classe SÃO estáticos, ou seja, podem ser usados sem ser instanciados.
 */

 package OO.membros_staticos.application;
 import java.util.Locale;
 import java.util.Scanner;
 import OO.membros_staticos.utils.Calculator3;
 
 public class Program3 {
     
     public static void main(String[] args) {
         Locale.setDefault(Locale.US);
         Scanner sc = new Scanner(System.in);

         //ATENÇÃO: Como os métodos de Calculator3 são estáticos, eu não preciso mais instancia-lo.
         //Calculator calc = new Calculator();
 
         System.out.print("Enter radius: ");
         double radius = sc.nextDouble();
 
         double c = Calculator3.circumference(radius);
 
         double v = Calculator3.volume(radius);
 
         System.out.printf("Circunference: %.2f%n", c);
         System.out.printf("Volume: %.2f%n", v);
         System.out.printf("PI value: %.2f%n", Calculator3.PI);
 
         sc.close();
     }
 
 }
 