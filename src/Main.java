import hotel.Customer;
import hotel.LuxuryRoom;
import services.Reservation;
import hotel.Room;
import services.ReservationService;

public class Main {
    public static void main(String[] args){
        Customer c = new Customer("Ali", "ali@example.com", "Paris");
        Room r = new LuxuryRoom("203", 150);
        Reservation res = new Reservation(r, c, 2);

        ReservationService service = new ReservationService();
        service.makeReservation(res, "paypal");
    }
}