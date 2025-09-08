package maaochou.mowerkata;

import java.util.Arrays;

public enum Direction {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    private final String directionCode;

    Direction(String directionCode) {
        this.directionCode = directionCode;
    }

    public static Direction fromCode(String directionCode) {
        return Arrays.stream(Direction.values()).filter(direction -> direction.directionCode.equals(directionCode)).findFirst().orElseThrow(() -> new IllegalArgumentException("Invalid direction code: " + directionCode));
    }
}
