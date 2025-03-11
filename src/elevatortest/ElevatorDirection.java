package elevatortest;

public enum ElevatorDirection {
    up {
        @Override
        public String elevatorDirection() {
            return " Going up... ";
        }
    },
    down {
        @Override
        public String elevatorDirection() {
            return " Going down... ";
        }
    };
    
    public abstract String elevatorDirection();
}
