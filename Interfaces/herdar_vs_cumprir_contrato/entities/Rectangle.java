package Interfaces.herdar_vs_cumprir_contrato.entities;

import Interfaces.herdar_vs_cumprir_contrato.enums.Color;

public class Rectangle extends AbstractShape{
    private double width;
    private double height;

    public Rectangle(){}

    public Rectangle(Color color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double area() {
        return width*height;
        //throw new UnsupportedOperationException("Unimplemented method 'area'");
    }
    
}
