package maaochou.mowerkata.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.function.Consumer;

public enum Instruction {
    FORWARD("A", Mower::moveForward), TURN_LEFT("G", Mower::turnLeft), TURN_RIGHT("D", Mower::turnRight);

    private final String instructionCode;
    private final Consumer<Mower> consumer;

    Instruction(String instructionCode, Consumer<Mower> consumer) {
        this.instructionCode = instructionCode;
        this.consumer = consumer;
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

    public void execute(Mower mower) {
        consumer.accept(mower);
    }
}
