/**
 * - Encapsulamento
 * É um princípio que consiste em esconder detalhes de implementação
 * de uma classe, expondo apenas operações seguras e que mantenham os
 * objetos em estado consistente. 
 * 
 * (private, public, getters and setters)
 * 
 */

package OO.encapsulamento.application;

import java.util.Locale;
import java.util.Scanner;

import OO.encapsulamento.entities.Product;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        Product product = new Product(name, price, quantity);

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
