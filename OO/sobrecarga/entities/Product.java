package OO.sobrecarga.entities;

public class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(){ //construtor padrão

    }

    public Product(String name, double price, int quantity){ //construtor da classe
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, double price){ //Sobrecarga do construtor
        this.name = name;
        this.price = price;
        //quantity = 0; //esse valor é opcional, pois o java inicia números de objetos e arrays com zero.
                        //assim como this também é opcional
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
