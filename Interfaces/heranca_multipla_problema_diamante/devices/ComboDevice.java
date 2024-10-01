package Interfaces.heranca_multipla_problema_diamante.devices;

public class ComboDevice extends Device implements Scanner, Printer {

    public ComboDevice(String serialNumber){
        super(serialNumber);
    }

    public void print(String doc){
        System.out.println("Combo Device printing: " + doc);
    }

    public void scan(String doc){
        System.out.println("Combo Device scanning: " + doc);
    }

    @Override
    public void processDoc(String doc){
        System.out.println("Combo Device processing: " + doc);
    }
}
