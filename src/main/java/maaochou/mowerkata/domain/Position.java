package maaochou.mowerkata.domain;

public record Position(int positionOnXAxis, int positionOnYAxis) {

    public Position {
        if (positionOnXAxis < 0) {
            throw new IllegalArgumentException("The X axis position is invalid");
        }
        if (positionOnYAxis < 0) {
            throw new IllegalArgumentException("The Y axis position is invalid");
        }
    }
}
