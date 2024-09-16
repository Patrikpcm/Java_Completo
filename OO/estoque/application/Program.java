package OO.estoque.application;

import java.util.Locale;
import java.util.Scanner;

import OO.estoque.entities.Product;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product product = new Product();
        System.out.print("Enter product data: ");
        System.out.print("Name: ");
        product.name = sc.nextLine();
        System.out.print("Price: ");
        product.price = sc.nextDouble();
        System.out.print("Quantity: ");
        product.quantity = sc.nextInt();

        System.out.println("Product data: " + product);

        System.out.print("/nEnter the number of products to be added in stock: ");
        product.addProductQuantity(sc.nextInt());
        System.out.println("Updated data: " + product);

        System.out.print("/nEnter the number of products to be removed from stock: ");
        product.removeProduct(sc.nextInt());
        System.out.println("Updated data: " + product);
        
        sc.close();
    }
}
