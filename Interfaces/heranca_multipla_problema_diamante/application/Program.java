package Interfaces.heranca_multipla_problema_diamante.application;

import Interfaces.heranca_multipla_problema_diamante.devices.ComboDevice;
import Interfaces.heranca_multipla_problema_diamante.devices.ConcretePrinter;
import Interfaces.heranca_multipla_problema_diamante.devices.ConcreteScanner;

/* 
 * Para contornar o problema do diamante, já que uma subclasse não pode herdar de mais de uma
 * superclasse, utilizamos interfaces:
 *
 *              #Device
 *             /        \
 *            /          \
 *       #Printer      #Scanner
 *            \          /
 *             \        /
 *            #ComboDevice
 * 
 *  Problema:
 *  - Fazer uma subclasse Printer e Scanner herdar de uma superclasse Device. - OK
 *  - Fazer uma subclasse ComboDevice herdar de Printer e Scanner. - ERRO
 * 
 * Contornamos o problema criando interfaces scanner e printer, fazendo a subclasse ComboDevide
 * herdar da classe abstrata Device e implementar as interfaces Printer e Scanner!
 *  
 * OBS: Isso NÃO É herança múltipla!
 */

public class Program {
    public static void main(String[] args) {
        
        ConcretePrinter p = new ConcretePrinter("1080");
        p.processDoc("My letter");
        p.print("My letter");

        ConcreteScanner s = new ConcreteScanner("2080");
        s.processDoc("My email");
        s.scan("My email");

        ComboDevice cb = new ComboDevice("1080-2080");
        cb.processDoc("My dissertation");
        cb.print("My dissertation");
        cb.scan("Scan result - My dissertation");
    }
}
