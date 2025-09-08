package maaochou.mowerkata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerMovementTest {

    @Test
    public void mower_placed_on_x_axis_zero_y_axis_zero_facing_north_and_moving_forward_should_be_found_on_x_axis_zero_y_axis_one_facing_north() {
        //Given
        int initialPositionOnXAxis = 0;
        int initialPositionOnYAxis = 0;
        Position initialPosition = new Position(initialPositionOnXAxis, initialPositionOnYAxis);
        Direction initialDirection = Direction.NORTH;

        Position expectedPosition = new Position(0, 1);
        Direction expectedDirection = Direction.NORTH;

        //When
        Mower mower = new Mower(initialPosition, initialDirection);
        mower.moveForward();

        //Then
        assertThat(mower).returns(expectedPosition, Mower::getPosition).returns(expectedDirection, Mower::getDirection);
    }

    @Test
    public void mower_placed_on_x_axis_zero_y_axis_zero_facing_east_and_moving_forward_should_be_found_on_x_axis_one_y_axis_zero_facing_east() {
        //Given
        int initialPositionOnXAxis = 0;
        int initialPositionOnYAxis = 0;
        Position initialPosition = new Position(initialPositionOnXAxis, initialPositionOnYAxis);
        Direction initialDirection = Direction.EAST;

        Position expectedPosition = new Position(1, 0);
        Direction expectedDirection = Direction.EAST;

        //When
        Mower mower = new Mower(initialPosition, initialDirection);
        mower.moveForward();

        //Then
        assertThat(mower).returns(expectedPosition, Mower::getPosition).returns(expectedDirection, Mower::getDirection);
    }

    @Test
    public void mower_placed_on_x_axis_one_y_axis_one_facing_west_and_moving_forward_should_be_found_on_x_axis_zero_y_axis_one_facing_west() {
        //Given
        int initialPositionOnXAxis = 1;
        int initialPositionOnYAxis = 1;
        Position initialPosition = new Position(initialPositionOnXAxis, initialPositionOnYAxis);
        Direction initialDirection = Direction.WEST;

        Position expectedPosition = new Position(0, 1);
        Direction expectedDirection = Direction.WEST;

        //When
        Mower mower = new Mower(initialPosition, initialDirection);
        mower.moveForward();

        //Then
        assertThat(mower).returns(expectedPosition, Mower::getPosition).returns(expectedDirection, Mower::getDirection);
    }

    @Test
    public void mower_placed_on_x_axis_one_y_axis_one_facing_south_and_moving_forward_should_be_found_on_x_axis_zero_y_axis_one_facing_south() {
        //Given
        int initialPositionOnXAxis = 1;
        int initialPositionOnYAxis = 1;
        Position initialPosition = new Position(initialPositionOnXAxis, initialPositionOnYAxis);
        Direction initialDirection = Direction.SOUTH;

        Position expectedPosition = new Position(1, 0);
        Direction expectedDirection = Direction.SOUTH;

        //When
        Mower mower = new Mower(initialPosition, initialDirection);
        mower.moveForward();

        //Then
        assertThat(mower).returns(expectedPosition, Mower::getPosition).returns(expectedDirection, Mower::getDirection);
    }
}
