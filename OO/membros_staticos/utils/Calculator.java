package OO.membros_staticos.utils;

public class Calculator {

    public final double PI = 3.141592; //A palavra final define que o valor é constante e não pode ser mudado.

    //Métodos sem ser estáticos
    public double circumference(double radius){
        return 2.0 * PI * radius;
    }

    //Métodos sem ser estáticos
    public double volume(double radius){
        return ( 4.0 * PI * radius * radius * radius ) / 3.0;
    }
}
