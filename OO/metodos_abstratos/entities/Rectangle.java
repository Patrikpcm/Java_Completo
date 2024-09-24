package OO.metodos_abstratos.entities;

import OO.metodos_abstratos.enums.Color;

public class Rectangle extends Shape{
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
