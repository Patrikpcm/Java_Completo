import java.util.Locale;
import java.util.Scanner;


class Product{
    private String name;
    private double price;

    Product(){}

    Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    //getters setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}

public class Vetores {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
 
        System.out.print("Defina o tamanho do vetor: ");
        int n = sc.nextInt();
        double[] vect = new double[n]; //declarando um vetor
        for(int i=0; i<n; i++){
            vect[i] = sc.nextDouble();
        }
        for (double d : vect) { //Laço foreach
            System.out.println(d);
        }

        System.out.print("Defina o tamanho do vetor Produtos: ");
        int p = sc.nextInt();
        Product[] produto = new Product[p];
        
        for(int i=0; i<p; i++){
            sc.nextLine(); //usado para pegar o espaço deixado pela tecla enter
            System.out.print("Entre com o nome do produto: ");
            String name = sc.nextLine();
            System.out.print("Entre com o preço do produto: ");
            double price = sc.nextDouble();
            produto[i] = new Product(name, price);
        }

        for (Product product : produto) { //laço foreach
            System.out.println("Produto - "+product+"\n"+product.getName()+" - R$"+product.getPrice()+"\n");
        }
        
        sc.close();
    }

   
}
