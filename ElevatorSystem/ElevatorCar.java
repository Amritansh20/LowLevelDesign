package ElevatorSystem;

public class ElevatorCar {
    int id;
    ElevatorDisplay elevatorDisplay;
    InternalButton internalButton;
    ElevatorState elevatorState;
    int currentFloor;
    ElevatorDoor elevatorDoor;
    Direction elevatorDirection;   

    public ElevatorCar(){
        elevatorDisplay = new ElevatorDisplay();
        internalButton = new InternalButton();
        currentFloor=0;
        elevatorState = ElevatorState.IDLE;
        elevatorDoor = new ElevatorDoor();
        elevatorDirection= Direction.UP;
    }

    public void showDisplay(){
        elevatorDisplay.showDisplay();
    }

    public void pressButton(int destination){
        internalButton.pressButton(destination, this);
    }

    public void setDisplay(){
        elevatorDisplay.setDisplay(currentFloor, elevatorDirection);
    }

    boolean moveElevator(Direction direction, int destinationFloor){
        int startFloor = currentFloor;

        if(direction == Direction.UP){
            for(int i=startFloor;i<=destinationFloor;i++){
                this.currentFloor=startFloor;
                setDisplay();
                showDisplay();

                if(i==destinationFloor)
                return true;
            }
        }

        if(direction == Direction.DOWN){
            for(int i=startFloor;i>=destinationFloor;i--){
                this.currentFloor=startFloor;
                setDisplay();
                showDisplay();

                if(i==destinationFloor)
                return true;
            }
        }
        return false;
    }

} 

