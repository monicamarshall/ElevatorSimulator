package elevatortest;

import java.util.HashMap;
import java.util.Map;

public enum ElevatorFloor {
	
	ground(0),
	levelOne(1),
    levelTwo(2),
	levelThree(3),
	levelFour(4),
	levelFive(5),
	levelSix(6);
	
    public final int floorNumber;

    private ElevatorFloor(int level) {
        this.floorNumber = level;
    }
	
    private static Map<Integer, ElevatorFloor> map = new HashMap<>();
    static {
        for (ElevatorFloor floor : values()) {
            map.put(floor.floorNumber, floor);
        }
    }
    
    public static ElevatorFloor byFloorNumber(int floorNumber) {
        return map.get(floorNumber);
    }
    
    public void getFloorNumber(ElevatorFloor floor) {
    	System.out.printf("At floor %d\n", floor.floorNumber);
    }
}
