package CarRentalSystem;

public class Bill{
    Reservation reservation;
    double totalBillAmount;
    boolean isPaid;

    Bill(Reservation reservation){
        this.reservation=reservation;
        this.totalBillAmount=totalBillAmount;
        this.isPaid =false;
    }

    private double computeAmount(){
        return 100.0;
    }
}