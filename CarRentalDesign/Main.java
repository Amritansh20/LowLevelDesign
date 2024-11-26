package CarRentalDesign;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RentalSystem rentalSystem=new RentalSystem();
        City city = new City("C", "New York");
        rentalSystem.addCity(city);
        
        Branch branch = new Branch("B","Oliver Square", city);
        city.addBranch(branch);

        Vehicle vehicle1 = new Vehicle("V1", "Toyota", "Camry",VehicleType.SUV, "NY-9876PM", 20, 30);
        Vehicle vehicle2 = new Vehicle("V2", "Honda", "CRV",VehicleType.SUV, "NY-80976PM", 40, 50);

        branch.addVehicle(vehicle1);
        branch.addVehicle(vehicle2);

        Customer customer = new Customer("C1", "John", "JH-0298");
        rentalSystem.addCustomer(customer);


        System.out.println("Avalable Vehicle in Oliver Square branch: ");
        List<Vehicle> vehicles = branch.getAvalableVehicle();
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }

        Booking booking = rentalSystem.createBooking("C1", "V2", LocalDateTime.now(), LocalDateTime.now().plusHours(5));
        Bill bill = rentalSystem.generateBill(booking, true);

        rentalSystem.processPayment(bill, PaymentMethod.CASH);

        System.out.println("Updated Vehicle Status : " + vehicle1.getRentalStatus());
        System.out.println("Updated Vehicle Status : " + vehicle2.getRentalStatus());
        
    }
    
}
