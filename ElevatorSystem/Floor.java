package ElevatorSystem;

public class Floor {
    int floorNumber;
    ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber){
        this.floorNumber=floorNumber;
       
    }

    public void pressButton(Direction direction){
        externalDispatcher.submitExternalRequest(floorNumber,direction);
    }
}
