package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

public class Store{

    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservations = new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vechileType){
       return vehicleInventoryManagement.getVehicles();
    }

    public void setVehicles(List<Vehicle> vehicles){
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.createReservation(vehicle,user);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationID) {
        return true;
    }

}