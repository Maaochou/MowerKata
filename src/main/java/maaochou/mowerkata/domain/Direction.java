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

    public Position moveForward(Position position, Field field) {
        int xAxis = Math.max(position.positionOnXAxis() + movementMovingForward.moveOnXAxisBy(), 0);
        int yAxis = Math.max(position.positionOnYAxis() + movementMovingForward.moveOnYAxisBy(), 0);
        if (field != null) {
            xAxis = Math.min(xAxis, field.maxPositionOnXAxis());
            yAxis = Math.min(yAxis, field.maxPositionOnYAxis());
        }

        return new Position(xAxis, yAxis);
    }

    public Direction turnLeft() {
        return values()[this.ordinal() - 1];
    }

    public Direction turnRight() {
        return values()[this.ordinal() + 1];
    }
}
