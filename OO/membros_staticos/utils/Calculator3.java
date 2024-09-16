package OO.membros_staticos.utils;

public class Calculator3 {

    public static final double PI = 3.141592; //A palavra final define que o valor é constante e não pode ser mudado.

    //Métodos sem ser estáticos
    public static double circumference(double radius){
        return 2.0 * PI * radius;
    }

    //Métodos sem ser estáticos
    public static double volume(double radius){
        return ( 4.0 * PI * radius * radius * radius ) / 3.0;
    }
}
