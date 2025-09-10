package maaochou.mowerkata.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import maaochou.mowerkata.domain.Direction;
import maaochou.mowerkata.domain.Instruction;

import java.util.List;

public record MowingSessionMowerDto(String id, @JsonProperty("start_position") PositionDto startPosition,
                                    Direction orientation,
                                    List<Instruction> instructions) {
}
