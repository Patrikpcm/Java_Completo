import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data_Hora {
    public static void main(String[] args) {
        
        LocalDate d01 = LocalDate.now(); //apenas data
        LocalDateTime d02 = LocalDateTime.now(); //data com hora
        Instant d03 = Instant.now(); //data e horário global(Londres), atenção para a letra Z no final. 
        LocalDate d04 = LocalDate.parse("2024-09-17");
        LocalDateTime d05 = LocalDateTime.parse("2024-09-17T11:00:26");
        Instant d06 = Instant.parse("2024-09-17T11:00:26Z");
        //Instant d07 = Instant.parse("2024-09-17T11:22:26-03:00");

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //criando formato para instanciar horas
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDate d08 = LocalDate.parse("18/09/2024", fmt1); //instancia customizada
        LocalDateTime d09 = LocalDateTime.parse("18/09/2024 11:30", fmt2); //instancia customizada


        //saída de formato personalizado
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("d01 = " + d01);
        System.out.println("d02 = " + d02);
        System.out.println("d03 = " + d03); 
        System.out.println("d04 = " + d04); 
        System.out.println("d05 = " + d05); 
        System.out.println("d06 = " + d06); 
        //System.out.println("d07 = " + d07); 
        System.out.println("d08 = " + d08); 
        System.out.println("d08 = " + d09);
        System.out.println("d01 = " + d01.format(fmt3)); //saída personalizada
        System.out.println("d01 = " + fmt3.format(d01)); //saída personalizada. Mesma chamada só que escrito de outra forma

        
    }
}