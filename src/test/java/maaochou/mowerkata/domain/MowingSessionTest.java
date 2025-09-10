package maaochou.mowerkata.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MowingSessionTest {

    @Test
    void mowing_session_having_two_mowers_in_same_field_executes_all_instructions_and_updates_states() {

        // Given
        Field field = new Field(5, 5);

        Mower firstMower = new Mower("mower1", new Position(0, 0), Direction.NORTH, field, List.of(Instruction.FORWARD, Instruction.FORWARD, Instruction.TURN_RIGHT, Instruction.FORWARD));
        Mower secondMower = new Mower("mower2", new Position(1, 1), Direction.EAST, field, List.of(Instruction.FORWARD, Instruction.FORWARD, Instruction.TURN_LEFT));
        MowingSession session = new MowingSession(List.of(firstMower, secondMower));

        Position expectedPositionOfFirstMower = new Position(1, 2);
        Position expectedPositionOfSecondMower = new Position(3, 1);

        // When
        session.executeMowersInstructions();

        // Then
        assertThat(firstMower)
                .returns(expectedPositionOfFirstMower, Mower::getPosition)
                .returns(Direction.EAST, Mower::getDirection)
                .returns(true, mower -> mower.getInstructions().isEmpty());

        assertThat(secondMower)
                .returns(expectedPositionOfSecondMower, Mower::getPosition)
                .returns(Direction.NORTH, Mower::getDirection)
                .returns(true, mower -> mower.getInstructions().isEmpty());
    }

}
