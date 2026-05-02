//Reasons this code needed a Facade pattern:
//1. Simplifies the booking process for clients by providing a single method to book a room 



public class BookingFacade {
    private RoomService rooms;
    private PaymentService payment;
    private LoyaltyPoints loyalty;
    private EmailService email;

    public BookingFacade() {
        this.rooms = new RoomService();
        this.payment = new PaymentService();
        this.loyalty = new LoyaltyPoints();
        this.email = new EmailService();
    }

    public boolean bookRoom(String guest, String roomType, double price) {
        if (!rooms.isAvailable(roomType)) return false;
        if (!payment.charge(guest, price)) return false;

        rooms.book(roomType, guest);
        loyalty.addPoints(guest, (int)price);
        email.sendConfirmation(guest, roomType);
        return true;
    }
}