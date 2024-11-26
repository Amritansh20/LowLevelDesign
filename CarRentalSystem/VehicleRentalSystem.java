package CarRentalSystem;

import java.util.List;

public class VehicleRentalSystem{
    List<User> userList;
    List<Store> storeList;

    public VehicleRentalSystem(List<User> userList, List<Store> storeList){
        this.storeList=storeList;
        this.userList=userList;
    }

    public Store getStore(Location location){
        return storeList.get(0);
    }

    //add user
    //remove user
    //add store
    //remove store;
}