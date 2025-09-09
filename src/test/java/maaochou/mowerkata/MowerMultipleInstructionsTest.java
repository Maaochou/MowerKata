package maaochou.mowerkata;

import maaochou.mowerkata.domain.Direction;
import maaochou.mowerkata.domain.Field;
import maaochou.mowerkata.domain.Instruction;
import maaochou.mowerkata.domain.Mower;
import maaochou.mowerkata.domain.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerMultipleInstructionsTest {

    @Test
    public void mower_placed_on_x0_y0_facing_north_and_moving_forward_twice_should_be_found_on_x0_y2_facing_north() {
        //Given
        int initialPositionOnXAxis = 0;
        int initialPositionOnYAxis = 0;
        Position initialPosition = new Position(initialPositionOnXAxis, initialPositionOnYAxis);
        Direction initialDirection = Direction.NORTH;

        Position expectedPosition = new Position(0, 2);
        Direction expectedDirection = Direction.NORTH;

        //When
        Mower mower = new Mower("mower1", initialPosition, initialDirection, null, List.of(Instruction.FORWARD, Instruction.FORWARD));
        mower.executeInstructions();

        //Then
        assertThat(mower).returns(expectedPosition, Mower::getPosition).returns(expectedDirection, Mower::getDirection);
    }

    @Test
    public void mower_placed_on_x0_y0_facing_north_and_moving_forward_5_times_then_turning_right_then_forward_6_times_should_be_found_on_x5_y5_facing_east() {
        //Given
        int initialPositionOnXAxis = 0;
        int initialPositionOnYAxis = 0;
        Position initialPosition = new Position(initialPositionOnXAxis, initialPositionOnYAxis);
        Direction initialDirection = Direction.NORTH;

        Field field = new Field(5, 5);

        Position expectedPosition = new Position(5, 5);
        Direction expectedDirection = Direction.EAST;

        //When
        Mower mower = new Mower("mower1", initialPosition, initialDirection, field, List.of(Instruction.FORWARD, Instruction.FORWARD, Instruction.FORWARD, Instruction.FORWARD, Instruction.FORWARD, Instruction.TURN_RIGHT, Instruction.FORWARD, Instruction.FORWARD, Instruction.FORWARD, Instruction.FORWARD, Instruction.FORWARD));
        mower.executeInstructions();

        //Then
        assertThat(mower).returns(expectedPosition, Mower::getPosition).returns(expectedDirection, Mower::getDirection);
    }

}
