package CarRentalSystem;

import java.sql.Date;

import CarRentalSystem.Product.Vehicle;

public class Reservation{
    int reservationId;
    Vehicle vehicle;
    User user;
    Date bookingDate;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickUpLocation;
    Location dropLocation;
    ReservationType resevationType;
    ReservationStatus reservationStatus;
    Location location;

    public int createReservation(Vehicle vehicle, User user){
        reservationId=123;
        this.user=user;
        this.vehicle=vehicle;
        resevationType = resevationType.DAILY;
        reservationStatus=reservationStatus.SCHEDULED;
        return reservationId;
    }
}