package CarRentalDesign;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    String id;
    String name;
    City city;
    List<Vehicle> vehicles;

    Branch(String id, String name, City city){
        this.id=id;
        this.name=name;
        this.city = city;
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAvalableVehicle(){
        List<Vehicle> availableVehicle = new ArrayList<>();

        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(i).getRentalStatus() == RentalStatus.AVAILABLE){
                availableVehicle.add(vehicles.get(i));
            }
        }
        return availableVehicle;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Branch{id='" + id + "', name='" + name + "', city='" + city.getName() + "'}";
    }

}
