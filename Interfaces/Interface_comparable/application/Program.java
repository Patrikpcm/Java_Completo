package Interfaces.Interface_comparable.application;

import Interfaces.Interface_comparable.entities.Employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Problema:
 * Prolema 1: Programa que lê um arquivo com nome de pessoas e armazená-os numa lista.
 * Depois, ordena os dados dessa lista e mostra-os ordenadamente na tela. 
 * 
 * Prolema 2: Programa que lê um arquivo com nome de pessoas e seus salários e armazená-os
 * numa lista. Depois, ordena os dados dessa lista e mostra-os ordenadamente na tela. Entretanto,
 * não conseguimos aplicar o método compareTo de Collections numa lista que não implementou a 
 * a interface compareTo. Para isso, fazemos a implementação dentro da classe Emplyee.
 * 
 * Basicamente, a interface Comparable define como um objeto deve ser comparado com outro.
 */

public class Program {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        String path = "Interfaces/Interface_comparable/funcionarios.txt";
     
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String employeeCsv = br.readLine();
            while(employeeCsv != null){
                String[] fields = employeeCsv.split(",");
                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeeCsv = br.readLine();
            }
            Collections.sort(list); //para utilizar sorte, precisamos implementar o compareTo dentro da classe Employee
            for (Employee emp : list){
                System.out.println(emp.getName() + ", " + emp.getSalary());
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }       
    }
}
