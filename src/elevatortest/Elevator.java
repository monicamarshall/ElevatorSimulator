package elevatortest;

public final class Elevator extends Thread{
	private static Elevator singleElevatorInstance;
	private ElevatorFloor currentFloor;   // The current floor the elevator is on
    private ElevatorState elevatorState; // The state in which the elevator is in
    private ElevatorDirection elevatorDirection; //The direction in which the elevator is moving

    // Constructor to initialize the elevator's state stopped at ground floor = 0
    private Elevator() {
        currentFloor = ElevatorFloor.ground;// Initially, elevator is at ground floor
        elevatorState = ElevatorState.stopped; // Initially, elevator is stopped
        System.out.println("Elevator is stopped at level 0");
    }
    
    public static Elevator getInstance() {
        if(singleElevatorInstance == null) {
        	singleElevatorInstance = new Elevator();
        }
        
        return singleElevatorInstance;
    }

    // Get the current floor of the elevator
    public ElevatorFloor getCurrentFloor() {
    	System.out.println("At floor " + getCurrentFloor());
        return currentFloor;
    }
    
    // Set the destination floor
    public void setCurrentFloor(ElevatorFloor destinationFloor) {
        currentFloor = destinationFloor;// Update the current floor to the destination floor
    }

    // Get the direction in which the elevator is moving
    public ElevatorDirection getDirection() {
        return elevatorDirection;
    }
    
    // Set the direction in which the elevator is moving
    public void setDirection(ElevatorDirection direction, ElevatorFloor currentFloor, ElevatorFloor destinationFloor) {
        this.elevatorDirection = direction;
        //elevatorDirection.elevatorDirection();
        int numberOfFloors = Math.abs(destinationFloor.floorNumber - currentFloor.floorNumber);
        System.out.printf(elevatorDirection.elevatorDirection() + numberOfFloors + " floor%s", "(s)\n");
    }
    
    // Get the direction in which the elevator is moving
    public ElevatorState getElevatorState() {
        return elevatorState;
    }
    
    // Set the direction in which the elevator is moving
    public void setElevatorState(ElevatorState state) {
        elevatorState = state;
        System.out.println(elevatorState.elevatorState());
    }

    // Move the elevator to the specified floor number
    public void goToFloor(int levelNumber, ElevatorUser user) throws InterruptedException {
    	ElevatorFloor destinationFloor = ElevatorFloor.byFloorNumber(levelNumber);
    	System.out.printf(user.getUsername() + " is going to level %d\n", levelNumber);
    	if( destinationFloor.compareTo(currentFloor) > 0) {
            setElevatorState(ElevatorState.stopped);
            setElevatorState(ElevatorState.openingDoor);
            setElevatorState(ElevatorState.closingDoor);
            setElevatorState(ElevatorState.moving);
    		this.setDirection(ElevatorDirection.up, currentFloor, destinationFloor); 
            currentFloor = destinationFloor;     // Update the current floor to the destination floor
            setElevatorState(ElevatorState.stopped);
            setElevatorState(ElevatorState.openingDoor);
            setElevatorState(ElevatorState.closingDoor);
            currentFloor.getFloorNumber(currentFloor);
    	}else if( destinationFloor.compareTo(currentFloor) < 0) {
            setElevatorState(ElevatorState.stopped);
            setElevatorState(ElevatorState.openingDoor);
            setElevatorState(ElevatorState.closingDoor);
            setElevatorState(ElevatorState.moving);
    		this.setDirection(ElevatorDirection.down, currentFloor, destinationFloor); 
            currentFloor = destinationFloor;     // Update the current floor to the destination floor
            setElevatorState(ElevatorState.stopped);
            setElevatorState(ElevatorState.openingDoor);
            setElevatorState(ElevatorState.closingDoor);
            currentFloor.getFloorNumber(currentFloor);
    	}else if( destinationFloor.compareTo(currentFloor) == 0) {
    		currentFloor.getFloorNumber(currentFloor);
    	}
    }
}
