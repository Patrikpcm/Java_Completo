package Interfaces.Default_methods.application;

import java.util.Scanner;
import java.util.Locale;

import Interfaces.Default_methods.services.BrazilInterestService;
import Interfaces.Default_methods.services.InterestService;

/**
 * Problema 1: Implementar um serviço que calcula a taxa de juros de empréstimo.
 * Problema 2: E se existir um serviço de juros de outro país?
 * 
 * Podemos criar uma interface que define a implementação dos métodos. Entretanto haverá
 * muita repetição de código, pra evitar isso, utilizamos default methods na interface.
 */

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amout: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService is = new BrazilInterestService(2.0);
        double payment = is.payment(amount, months);

        System.out.println("Payment after " + months + "months: ");
        System.out.println(String.format("%.2f", payment));
    }
}
