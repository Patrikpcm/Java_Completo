/*
 * Nesse exemplo, separamos os membros de instância numa classe separada chamada Calculator.
 * Todos os membros dessa classe são NÃO estáticos. 
 */

 package OO.membros_staticos.application;
 import java.util.Locale;
 import java.util.Scanner;
 import OO.membros_staticos.utils.Calculator;
 
 public class Program2 {
     
     public static void main(String[] args) {
         Locale.setDefault(Locale.US);
         Scanner sc = new Scanner(System.in);

         //ATENÇÃO: Como os métodos de Calculator não são estáticos, precisamos estânciar um calculator
         Calculator calc = new Calculator();
 
         System.out.print("Enter radius: ");
         double radius = sc.nextDouble();
 
         double c = calc.circumference(radius);
 
         double v = calc.volume(radius);
 
         System.out.printf("Circunference: %.2f%n", c);
         System.out.printf("Volume: %.2f%n", v);
         System.out.printf("PI value: %.2f%n", calc.PI);
 
         sc.close();
     }
 
 }
 