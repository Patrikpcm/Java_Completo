package OO.modificadores_de_acesso.entities;

public class Product {
    private String name;
    private int quantity;
    private double price;
    
    public Product(){} //construtor padrão

    public Product(String name, double price, int quantity){ //construtor da classe
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //quantidade de produto só pode mudar através das operações de entrada e saída do estoque
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
