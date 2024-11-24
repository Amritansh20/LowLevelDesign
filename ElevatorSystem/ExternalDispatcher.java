package ElevatorSystem;

import java.util.List;

public class ExternalDispatcher {
    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;
    
    public void submitExternalRequest(int floorNumber, Direction direction){

        for(ElevatorController elevatorController : elevatorControllerList){
            int elevatorId = elevatorController.elevatorCar.id;
            
            if(elevatorId%2==1 && floorNumber%2==1){
                elevatorController.submitExternalRequest(floorNumber, direction);
            }else if(elevatorId%2==0 && floorNumber%2==0){
                elevatorController.submitExternalRequest(floorNumber, direction);
            }
        }
    }
}
