package CarRentalDesign;

public class Bill {
    private String id;
    Booking booking;
    private double amount;

    public Bill(String id, Booking booking, double amount){
        this.id=id;
        this.booking=booking;
        this.amount=amount;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Bill{id='" + id + "', bookingId='" + booking.getId() + "', amount=" + amount + "}";
    }
}
