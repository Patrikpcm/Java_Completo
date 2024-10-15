package OO.triangulos.comOO.application;

import java.util.Locale;
import java.util.Scanner;

import OO.triangulos.comOO.entities.Triangle;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US); //definindo a região como US para poder entrar com "."
        Scanner sc = new Scanner(System.in);

        Triangle x, y;
        x = new Triangle();
        y = new Triangle();

        System.out.println("Enter the measures of triangle X:");
        x.A = sc.nextDouble();
        x.B = sc.nextDouble();
        x.C = sc.nextDouble();

        System.out.println("Enter the measures of triangle Y:");
        y.A = sc.nextDouble();
        y.B = sc.nextDouble();
        y.C = sc.nextDouble();

        System.out.println("Triangle X area: "+ x.calculaArea());
        System.out.println("Triangle Y area: "+ y.calculaArea());

        if(x.calculaArea() > y.calculaArea())
            System.out.println("Large area: X");
        else
            System.out.println("Large area: Y");
            
        sc.close();
    }
}