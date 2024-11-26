package CarRentalDesign;

public class Customer {
    String id;
    String name;
    String driverLicence;

    Customer(String id, String name, String driverLicence){
        this.id=id;
        this.name=name;
        this.driverLicence=driverLicence;
    }


    public String getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Customer{id='" + id + "', name='" + name + "'}";
    }
}   
