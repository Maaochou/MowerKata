package maaochou.mowerkata.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

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
    }, TURN_RIGHT("D") {
        @Override
        public void execute(Mower mower) {
            mower.turnRight();
        }
    };

    private final String instructionCode;

    Instruction(String instructionCode) {
        this.instructionCode = instructionCode;
    }

    @JsonCreator
    public static Instruction fromCode(String code) {
        for (Instruction i : Instruction.values()) {
            if (i.instructionCode.equals(code)) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid instruction code: " + code);
    }

    public abstract void execute(Mower mower);
}
