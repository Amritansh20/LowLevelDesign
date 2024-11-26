package CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

import CarRentalSystem.Product.Car;
import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;

public class Main{
    public static void main(String[] args) {
        List<User> users = addUser();
        List<Vehicle> vehicles = addVehicle();
        List<Store> stores = addStore(vehicles);

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(users, stores);
        User user = users.get(0);
        Location location =  new Location(825301, "Hazaribagh", "Jharkhand", "India");
        Store store = vehicleRentalSystem.getStore(location);

        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

        Reservation reservation = store.createReservation(storeVehicles.get(0), users.get(0));
        Bill bill = new Bill(reservation);

        Payment payment = new Payment();
        payment.payBill(bill);

        store.completeReservation(reservation.reservationId);
    }

    public static List<Vehicle> addVehicle(){
        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle v1 = new Car();
        v1.setVehicleId(1);
        v1.setVechileType(VehicleType.CAR);

        Vehicle v2 = new Car();
        v1.setVehicleId(2);
        v1.setVechileType(VehicleType.CAR);

        vehicles.add(v1);
        vehicles.add(v2);

        return vehicles;
    }

    public static List<User> addUser(){
        List<User> users = new ArrayList<>();

        User u1 = new User();
        u1.setUserId(1);

        users.add(u1);
        return users;
    }

    public static List<Store> addStore(List<Vehicle> vehicles){
        List<Store> stores = new ArrayList<>();

        Store s1 = new Store();
        s1.storeId=1;
        s1.setVehicles(vehicles);

        stores.add(s1);
        return stores;
    }

}
