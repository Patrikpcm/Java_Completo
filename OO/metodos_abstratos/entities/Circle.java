package OO.metodos_abstratos.entities;

import OO.metodos_abstratos.enums.Color;

public class Circle extends Shape {
    private Double radius;

    public Circle(){
    }
    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }
    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return (Math.PI * (radius*radius));
        //throw new UnsupportedOperationException("Unimplemented method 'area'");
    }
    
}
