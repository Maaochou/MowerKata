package maaochou.mowerkata.application.dto;

import maaochou.mowerkata.domain.Direction;

public record MowerDto(String id, PositionDto position, Direction orientation) {
}
