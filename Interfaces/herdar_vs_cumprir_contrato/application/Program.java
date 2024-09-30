package Interfaces.herdar_vs_cumprir_contrato.application;

import java.util.Locale;
import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import Interfaces.herdar_vs_cumprir_contrato.entities.AbstractShape;
import Interfaces.herdar_vs_cumprir_contrato.enums.Color;
import Interfaces.herdar_vs_cumprir_contrato.entities.Rectangle;
import Interfaces.herdar_vs_cumprir_contrato.entities.Circle;

/*
 * Nesse exemplo estamos fazendo as duas coisas, utilizando uma classe abstrata e um contrato
 * de interface. Diferente do exercício de métodos abstratos que também utilizou  esse exemplo
 * de formas.
 * Nesse exemplo utilizamos um contrato Shape que define o método area() a ser 
 * implementado.
 * Nas entidades criamos uma classe abstrata AbstractShape que define o atributo color e 
 * implementa o contrato shape. 
 * Na classe principal program, apenas mudamos a instância dos objetos de Shape para AbstractShape.
 * Dessa forma trabalhamos com as 2 possibilidades semelhantes, mas não iguais, de definições
 * de classe (contrato e abstração) e podemos analisar melhor a diferença entre elas.
 * A principal é que classes contrato não podem ter atributos definidos (por isso da utilização
 * de uma classe abstrata).
 */

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        List<AbstractShape> list = new ArrayList<>();

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
                //AbstractShape rectangle = new Rectangle(color, width, height);
                list.add(new Rectangle(color, width, height)); //não preciso instanciar um objeto
                /*
                    Como a lista já é do tipo genérico AbstractShape, basta eu instanciar o objeto diretamente
                    dentro da lista.
                */
            }
        }

        System.out.println("\nSHAPE AREAS:");
        for (AbstractShape shape : list) {
            System.out.println(String.format("%.2f", shape.area()));
        }

        sc.close();
    }
    
}