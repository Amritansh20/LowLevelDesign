package  CarRentalSystem;

public class Location{
    String address;
    int pincode;
    String city;
    String state;
    String country;

    public Location(int pincode, String city, String state, String country){
        this.country=country;
        this.pincode=pincode;
        this.state=state;
        this.city=city;
    }
}