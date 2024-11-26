package CarRentalDesign;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    List<City> cities;
    List<Customer> customers;

    public RentalSystem(){
        this.cities=new ArrayList<>();
        this.customers= new ArrayList<>();
    }

    public void addCity(City city){
        cities.add(city);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public List<Vehicle> getAvailableVehicle(String cityName, String branchName){
        List<Vehicle> vehicles = new ArrayList<>();

        for(City city : cities){
            if(city.getName().equalsIgnoreCase(cityName)){
                for(Branch branch : city.getBranches()){
                    if(branch.getName().equalsIgnoreCase(branchName)){
                        vehicles = branch.getAvalableVehicle();
                    }
                }
            }
        }
        return vehicles;
    }

    public Booking createBooking(String customerId, String vechicleId, LocalDateTime startTime, LocalDateTime endTime){
        Customer customer = findCustomerById(customerId);
        Vehicle vehicle = findVehicleById(vechicleId);

        if(customer==null || vehicle==null || vehicle.getRentalStatus() != RentalStatus.AVAILABLE){
            System.out.println("Cannot create booking");
            return null;
        }

        Booking booking = new Booking("B"+ System.currentTimeMillis(), customer, vehicle, startTime, endTime);
        System.out.println("Booking created successfully " + booking);
        return booking;
        
    }

    public Bill generateBill(Booking booking, boolean hourlyRate){
        long hours = java.time.Duration.between(booking.getStartTime(), booking.getEndTime()).toHours();
        double totalAmount = hourlyRate ? booking.getVehicle().getPricePerHour() * hours : booking.getVehicle().getPricePerDay() * Math.ceil(hours/24);

        Bill bill = new Bill("Bill"+System.currentTimeMillis(), booking, totalAmount);
        System.out.println("Bill generated " + bill );
        return bill;
    }

    public Payment processPayment(Bill bill, PaymentMethod paymentMethod){
        Payment payment = new Payment("P"+System.currentTimeMillis(), bill, paymentMethod);
        payment.completePayment();
        System.out.println("Payment completed");
        return payment;
    }

    public Customer findCustomerById(String customerId){
        for(Customer customer : customers){
            if(customer.getId().equals(customerId)){
                return customer;
            }
        }
        return null;
    }

    public Vehicle findVehicleById(String vehicleId){
        for(City city : cities){
            for(Branch branch: city.getBranches()){
                for(Vehicle vehicle : branch.getAvalableVehicle()){
                    if(vehicle.getId().equals(vehicleId))
                    return vehicle;
                }
            }
        }
        return null;
    }

 
}
