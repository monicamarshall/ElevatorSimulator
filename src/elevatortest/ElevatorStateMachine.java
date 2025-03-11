package elevatortest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class ElevatorStateMachine extends Thread{	

	public static int ground = ElevatorFloor.ground.floorNumber;
	public static int levelSix = ElevatorFloor.levelSix.floorNumber;
	public static final int numberOfElevatorUsers = 10;
 
    public static void main(String... args) {    
    	Elevator elevator = Elevator.getInstance();
    	
        // Create a thread pool with three threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("In function main for ElevatorStateMachine.  Simulating 10 users using one single elevator....");
        for (int i = 0; i < numberOfElevatorUsers; ++i) {
        	final int taskNumber = i;
        	executor.execute(() -> {
                ElevatorUser user = new ElevatorUser(taskNumber);
            	int floorNumber = ThreadLocalRandom.current().nextInt(ground, levelSix);
            	try {
    				elevator.goToFloor(floorNumber, user);
    				Thread.sleep(2000);
    			} catch (InterruptedException e) {

    			}
            });        	
        }
        // Shutdown the thread pool
        executor.shutdown();
    }
 
}

