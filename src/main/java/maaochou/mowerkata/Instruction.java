package maaochou.mowerkata;

public enum Instruction {
    FORWARD("A") {
        @Override
        public void execute(Mower mower) {
            mower.moveForward();
        }
    }, TURN_LEFT("G") {
        @Override
        public void execute(Mower mower) {
            mower.turnLeft();
        }
    }, TURN_RIGHT("R") {
        @Override
        public void execute(Mower mower) {
            mower.turnRight();
        }
    };

    private final String instruction;

    Instruction(String instruction) {
        this.instruction = instruction;
    }

    public abstract void execute(Mower mower);
}
