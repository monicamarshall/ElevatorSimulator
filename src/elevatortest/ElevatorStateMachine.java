package elevatortest;

import java.util.concurrent.ThreadLocalRandom;

public class ElevatorStateMachine extends Thread{	

	public static int ground = ElevatorFloor.ground.floorNumber;
	public static int levelSix = ElevatorFloor.levelSix.floorNumber;
	public static final int numberOfElevatorUsers = 10;
 
    public static void main(String... args) {    
    	Elevator elevator = Elevator.getInstance();

        System.out.println("In function main for ElevatorStateMachine.  Simulating 10 users using one single elevator....");
        for (int i = 0; i < numberOfElevatorUsers; ++i) {
        	ElevatorUser user = new ElevatorUser(i);
        	int floorNumber = ThreadLocalRandom.current().nextInt(ground, levelSix);
        	try {
				elevator.goToFloor(floorNumber, user);
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}
        }

    }
 
}

