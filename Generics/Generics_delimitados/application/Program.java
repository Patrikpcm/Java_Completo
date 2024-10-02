package Generics.Generics_delimitados.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ArrayList;
import Generics.Generics_delimitados.services.CalculationService;
import Generics.Generics_delimitados.entities.Product;
/* PROBLEMA EXEMPLO
 * Uma empresa de consultoria deseja avaliar a performance de produtos, funcionários,
 * dentre outras coisas. Um dos cálculos que ela precisa é encontrar o maior dentre um
 * conjunto de elementos. Fazer um programa que leia um conjunto de produtos a parir de
 * um arquivo.
 */

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();
        String path = "Generics/Generics_delimitados/in.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while(line!=null){
                String[] fields = line.split(",");
                list.add(new Product(fields[0],Double.parseDouble(fields[1])));
                line = br.readLine();
            }
            Product x = CalculationService.max(list);
            System.out.println("Most expensive: ");
            System.out.println(x);
        }
        catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
