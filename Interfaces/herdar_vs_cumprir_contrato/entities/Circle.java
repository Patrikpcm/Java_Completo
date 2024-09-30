package Interfaces.herdar_vs_cumprir_contrato.entities;

import Interfaces.herdar_vs_cumprir_contrato.enums.Color;

public class Circle extends AbstractShape {
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
