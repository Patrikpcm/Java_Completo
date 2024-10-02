package Generics.Introducao.application;
import Generics.Introducao.services.PrintService;
import java.util.Scanner;

/*
 * Problema motivador 1 (reuso):
 * Fazer um programa que leia uma quantidade N, e depois N números inteiros. Ao final, imprima
 * esses números de forma organizada e por fim informar quem foi o primeiro valor.
 * MAS... e se eu quisesse utilizar o serviço de impressão para Strings?
 */

public class Program{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintService<Integer> ps = new PrintService<>(); //Problema 3 - Parametrizando o printservice para Integer
        System.out.print("How many values? ");
        int n = sc.nextInt();
    
        //ps.addValue("Maria"); //reclama que não pode adicionar uma string (TypeSafety)

        for (int i=0; i<n; i++){
            int value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        //Problema do Type Safety
        /*Integer x = (Integer)ps.first();  Reclama que não pode converter Object para integer, 
                                            a não ser que façamos um cast. MAS E SE o primeiro objeto for
                                            uma String? Evitamos isso usando Generics*/
        System.out.println("First: " + ps.first());

        sc.close();
    }   
}