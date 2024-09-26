package OO.tratamento_excecoes.excecoes_personalizadas.solucao_ruim.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    
    /*formatando a data e definindo como estática para não ser instanciada um SDF 
    para cada objeto Reservation que a aplicação tiver.*/
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 

    public Reservation(){}
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Date getCheckin() {
        return checkIn;
    }
   
    public Date getCheckout() {
        return checkOut;
    }
    
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkin, Date checkout){

        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)){
            return ("Reservation dates for update must be future dates");
        }
        else if(!checkout.after(checkin)){
            return ("Check-out date must be after check-in date");
        }
        else{
            this.checkIn = checkin;
            this.checkOut = checkout;
        }
        return null; 
    }

    @Override
    public String toString(){
        return "Room "
                + roomNumber
                + ", check-in "
                + sdf.format(checkIn)
                + ", check-out "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }
   
}
