/**
 * - Modificadores de Acesso
 * Private  - O membro só pode ser acessado na própria classe
 * (nada)   - O membro só pode ser acessado nas classes do mesmo pacote
 * Protected- O membro só pode ser acessado no mesmo pacote, bem como em subclasses de pacotes diferentes 
 * public   - O membro é acessado por todas classes (ao menos que ele resida em um módulo diferente)
 */

package OO.modificadores_de_acesso.application;

import java.util.Locale;
import java.util.Scanner;

import OO.modificadores_de_acesso.entities.Product;

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
