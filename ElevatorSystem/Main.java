package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Floor> floorList = new ArrayList<>();
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        Floor floor4 = new Floor(4);
        Floor floor5 = new Floor(5);

        Building building= new Building(floorList);

}
