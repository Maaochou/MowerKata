package maaochou.mowerkata.domain;

import java.util.Arrays;

public enum Direction {
    NORTH("N", new Movement(0, 1)) {
        @Override
        public Direction turnLeft() {
            return WEST;
        }
    }, EAST("E", new Movement(1, 0)), SOUTH("S", new Movement(0, -1)), WEST("W", new Movement(-1, 0)) {
        @Override
        public Direction turnRight() {
            return NORTH;

        }
    };

    private final String directionCode;
    private final Movement movementMovingForward;

    Direction(String directionCode, Movement movementMovingForward) {
        this.directionCode = directionCode;
        this.movementMovingForward = movementMovingForward;
    }

    public static Direction fromCode(String directionCode) {
        return Arrays.stream(Direction.values()).filter(direction -> direction.directionCode.equals(directionCode)).findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid direction code: " + directionCode));
    }

    public Position moveForward(Position position) {
        return new Position(position.positionOnXAxis() + movementMovingForward.moveOnXAxisBy(), position.positionOnYAxis() + movementMovingForward.moveOnYAxisBy());
    }

    public Direction turnLeft() {
        return values()[this.ordinal() - 1];
        //return Arrays.stream(Direction.values()).filter(direction -> direction.ordinal() == (this.ordinal() - 1)).findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid direction code: " + this.directionCode));
    }

    public Direction turnRight() {
        return values()[this.ordinal() + 1];
    }
}
