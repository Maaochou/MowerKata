package maaochou.mowerkata;

import maaochou.mowerkata.domain.Direction;
import maaochou.mowerkata.domain.Mower;
import maaochou.mowerkata.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerPlacementTest {

    @Test
    public void mower_placed_on_x_axis_zero_y_axis_zero_facing_north_should_be_found_on_x_axis_zero_y_axis_zero_facing_north() {
        //Given
        int positionOnXAxis = 0;
        int positionOnYAxis = 0;
        Position initialPosition = new Position(positionOnXAxis, positionOnYAxis);
        Direction initialDirection = Direction.NORTH;

        Position expectedPosition = new Position(positionOnXAxis, positionOnYAxis);
        Direction expectedDirection = Direction.NORTH;
        //When
        Mower mower = new Mower("mower1", initialPosition, initialDirection, null, null);

        //Then
        assertThat(mower).returns(expectedPosition, Mower::getPosition).returns(expectedDirection, Mower::getDirection);
    }
}
