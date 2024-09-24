package OO.metodos_abstratos.application;

import java.util.Locale;
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import OO.metodos_abstratos.entities.Shape;
import OO.metodos_abstratos.enums.Color;
import OO.metodos_abstratos.entities.Rectangle;
import OO.metodos_abstratos.entities.Circle;

/*
 *  MÉTODOS ABSTRATOS
 * - São métodos que não possuem implementação.
 * - Métodos precisam ser abstratos quando a classe é genérica demais para conter sua implementação
 * - Se uma classe possuir pelo menos um método abstrato, então essa classe também é abstrata
 * - Notação UML: Itálico
 * 
 *  EXEMPLO
 * - Temos a implementação de um programa que calcula a área de figuras, entretanto, a forma de
 *   calcular a área das mesmas é diferente conforme sua forma. A área de um retangulo é calculada
 *   como base*altura, enquanto a área de um círculo é calculada com pi*r² .
 * - Dessa forma, a implementação de um método genérico o suficiente para ser utilizado com polimorfismo
 *   não pode ter uma implementação, já que essa muda conforme a figura. 
 */

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        List<Shape> list = new ArrayList<>();

        for (int i=1; i<=n; i++){
            System.out.println("Shape #"+i+" data:");
            System.out.print("Rectangle or Circle (r/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next());
            if(ch == 'c'){
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                //Shape circle = new Circle(color, radius);
                list.add(new Circle(color, radius));
                /*
                    Como a lista já é do tipo genérico Shape, basta eu instanciar o objeto diretamente
                    dentro da lista.
                */
            }
            else{
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                //Shape rectangle = new Rectangle(color, width, height);
                list.add(new Rectangle(color, width, height)); //não preciso instanciar um objeto
                /*
                    Como a lista já é do tipo genérico Shape, basta eu instanciar o objeto diretamente
                    dentro da lista.
                */
            }
        }

        System.out.println("\nSHAPE AREAS:");
        for (Shape shape : list) {
            System.out.println(String.format("%.2f", shape.area()));
        }

        sc.close();
    }
    
}