package CarRentalDesign;

public class Payment {
    String id;
    Bill bill;
    PaymentMethod paymentMethod;
    PaymentStatus paymentStatus;

    public Payment(String id, Bill bill, PaymentMethod paymentMethod){
        this.id=id;
        this.bill=bill;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void completePayment(){
        this.paymentStatus = PaymentStatus.COMPLETED;
    }

    @Override
    public String toString() {
        return String.format("Payment{id='%s', billId='%s', paymentMethod='%s', status='%s'}", id, bill.getId(), paymentMethod, paymentStatus);
    }
}
