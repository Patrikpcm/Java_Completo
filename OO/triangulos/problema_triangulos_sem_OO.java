/*
 * O problema dos triângulos consiste em realizar a soma da área de dois triângulos
 * X e Y e imprimir na saída o tamanho de suas áreas e qual dos dois tem a maior. 
 */

package OO.triangulos;

import java.util.Locale;
import java.util.Scanner;

public class problema_triangulos_sem_OO {
    public static void main(String[] args) {
        double xA, xB, xC, yA, yB, yC;
        Locale.setDefault(Locale.US); //definindo a região como US para poder entrar com "."

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the measures of triangle X:");
        xA = sc.nextDouble();
        xB = sc.nextDouble();
        xC = sc.nextDouble();
        System.out.println("Enter the measures of triangle Y:");
        yA = sc.nextDouble();
        yB = sc.nextDouble();
        yC = sc.nextDouble();

        double areaX, areaY, pX, pY;
        pX = (xA+xB+xC)/2 ;
        pY = (yA+yB+yC)/2 ;
        areaX = Math.sqrt(pX*(pX-xA)*(pX-xB)*(pX-xC));
        areaY = Math.sqrt(pY*(pY-yA)*(pY-yB)*(pY-yC));

        System.out.println("Triangle X area: "+ areaX);
        System.out.println("Triangle Y area: "+ areaY);

        if(areaX > areaY)
            System.out.println("Large area: X");
        else
            System.out.println("Large area: Y");
        
    }
}
