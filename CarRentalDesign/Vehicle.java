package CarRentalDesign;

public class Vehicle {
    private String id;
    private String make;
    private String model;
    private VehicleType vehicleType;
    private String licenceNumber;
    private int pricePerHour;
    private int pricePerDay;
    private RentalStatus rentalStatus;

    Vehicle(String id, String make, String model, VehicleType vehicleType, String licenceNumber, int pricePerHour, int pricePerDay){
        this.id=id;
        this.make=make;
        this.model=model;
        this.vehicleType=vehicleType;
        this.licenceNumber=licenceNumber;
        this.pricePerDay=pricePerDay;
        this.pricePerHour=pricePerHour;
        this.rentalStatus=RentalStatus.AVAILABLE;
    }

    public void setRentalStatus(RentalStatus rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public RentalStatus getRentalStatus() {
        return rentalStatus;
    }

    public String getId() {
        return id;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return String.format("Vehicle{id='%s', make='%s', model='%s', type='%s', status='%s'}", id, make, model, vehicleType, rentalStatus);
    }
}
