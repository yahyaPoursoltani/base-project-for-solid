package services;

public class ReservationService {
    private EmailSender emailSender = new EmailSender();
    private PaymentProcessor paymentProcessor = new PaymentProcessor();

    public void makeReservation(Reservation res, String paymentType){
        System.out.println("Processing reservation for " + res.customer.name);

        if(res.customer.city.equals("Paris")){
            System.out.println("Apply city discount for Paris!");
            res.room.price *= 0.9;
        }

        if(paymentType.equals("card")){
            paymentProcessor.payByCard(res.totalPrice());
        } else if(paymentType.equals("cash")){
            paymentProcessor.payByCash(res.totalPrice());
        } else if(paymentType.equals("paypal")){
            paymentProcessor.payByPayPal(res.totalPrice());
        }

        System.out.println("----- INVOICE -----");
        System.out.println("hotel.Customer: " + res.customer.name);
        System.out.println("hotel.Room: " + res.room.number + " (" + res.room.type + ")");
        System.out.println("Total: " + res.totalPrice());
        System.out.println("-------------------");

        emailSender.sendEmail(res.customer.email, "Your reservation confirmed!");
    }
}