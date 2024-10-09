package Generics.Curinga_delimitado.application;

import java.util.ArrayList;
import java.util.List;

import Generics.Curinga_delimitado.entities.Shape;
import Generics.Curinga_delimitado.entities.Rectangle;
import Generics.Curinga_delimitado.entities.Circle;

public class Program {
    public static void main(String[] args) {
        
        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));
        System.out.println("Total area: " + totalArea(myShapes));

        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));
        //System.out.println("Total area: " + totalArea(myCircles));
        /* Essa ação para um vetor de circúlos não é permitida pois a função de totalArea()
         * calcula apenas lista do tipo Shape. Mesmo Circle sendo subtipo de Shape, 
         * teremos problema.
         * Para isso funcionar, teremos que ajustar a função totalArea() para receber tipos 
         * curinga.
         */
        System.out.println("Total area: " + totalArea(myCircles));
    }
    /*Com esse ajuste(extends shape), esse metodo funciona tanto para circulos 
      como para qualquer outro formato que implemente Shape.*/
    public static double totalArea(List<? extends Shape> list){ //tipo curinga delimitado
        double sum = 0.0;
        for (Shape s : list){
            sum += s.area();
        }
        return sum;
    }
}   
    /*
    public static double totalArea(List<Shape> list){
        double sum = 0.0;
        for (Shape s : list){
            sum += s.area();
        }
        return sum;
    }
    */