package maaochou.mowerkata.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Mower {
    private String id;
    private Position position;
    private Direction direction;
    private Field field;
    private List<Instruction> instructions;

    public Mower(String id, Position position, Direction direction, Field field, List<Instruction> instructions) {
        this.id = id;
        this.position = position;
        this.direction = direction;
        this.field = field;
        // force the instruction list to be mutable.
        this.instructions = instructions != null ? new ArrayList<>(instructions) : new ArrayList<>();
    }

    public void moveForward() {
        setPosition(direction.moveForward(position, field));
    }

    public void turnLeft() {
        setDirection(direction.turnLeft());
    }

    public void turnRight() {
        setDirection(direction.turnRight());
    }

    public void executeInstructions() {
        for (int i = 0; i < instructions.size(); ) {
            instructions.get(i).execute(this);
            // I decided arbitrarily that an executed instruction is removed.
            instructions.remove(i);
        }
    }
}
