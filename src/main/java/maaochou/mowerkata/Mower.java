package maaochou.mowerkata;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Mower {
    private Position position;
    private Direction direction;

    public void moveForward() {
        setPosition(direction.moveForward(position));
    }

    public void turnLeft() {
        setDirection(direction.turnLeft());
    }

    public void turnRight() {
        setDirection(direction.turnRight());
    }
}
