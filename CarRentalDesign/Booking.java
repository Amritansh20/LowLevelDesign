package CarRentalDesign;

import java.time.LocalDateTime;


public class Booking{
        private String id;
        private Customer customer;
        private Vehicle vehicle;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
    
        private String status;

        public Booking(String id, Customer customer, Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime){
            this.id=id;
            this.customer=customer;
            this.vehicle=vehicle;
            this.startTime=startTime;
            this.endTime=endTime;
            status = "BOOKED";
            vehicle.setRentalStatus(RentalStatus.BOOKED);
        }

        public String getId() {
            return id;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public void cancleBooking(){
            this.status = "CANCELLED";
            this.vehicle.setRentalStatus(RentalStatus.AVAILABLE);
        }

        public String getStatus(){
            return status;
        }

        @Override
        public String toString() {
            return String.format("Booking{id='%s', customer='%s', vehicle='%s', startTime='%s', endTime='%s', status='%s'}",
                    id, customer.getId(), vehicle.getId(), startTime, endTime, status);
        }
}
