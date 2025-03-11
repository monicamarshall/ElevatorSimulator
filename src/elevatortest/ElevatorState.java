package elevatortest;

public enum ElevatorState {

    openingDoor {
        @Override
        public String elevatorState() {
            return " Doors are opening...";
        }
    },
    closingDoor {
        @Override
        public String elevatorState() {
            return " Doors are closing...";
        }
    },
    moving {
        @Override
        public String elevatorState() {
            return " Elevator is moving... ";
        }
    },
    stopped {
        @Override
        public String elevatorState() {
            return " Elevator has stopped...";
        }
    };
    
    public abstract String elevatorState();
}
