package OO.triangulos.comOO.entities;

public class Triangle{
    public double A;
    public double B;
    public double C;

    public double calculaArea(){
        double p = (A+B+C)/2;
        return Math.sqrt(p*(p-A)*(p-B)*(p-C));
    }
}
