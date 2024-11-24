package ElevatorSystem;

public class InternalButton {
    InternalDispatcher internalDispatcher;
    int[] availableButtons = {1,2,3,4,5,6,7,8,9,10};

    public void pressButton(int destination, ElevatorCar elevatorCar){
        internalDispatcher.submitInternalRequest(destination,elevatorCar);
    }
}   
