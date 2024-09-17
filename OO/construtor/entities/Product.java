package OO.construtor.entities;

public class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price, int quantity){ //construtor da classe
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double totalValueInStock(){
        return price * quantity;
    }

    public void addProductQuantity(int quantity){
        this.quantity += quantity;
    }

    public void removeProduct(int quantity){
        this.quantity -= quantity;
    }

    public String toString(){ //sobrepondo a classe padrão do object
        return (
                name + ", $ " + String.format("%.2f", price) 
                + ", " 
                + quantity + " units, Total: $ " 
                + String.format("%.2f", totalValueInStock()) 
               );
    }

}   
