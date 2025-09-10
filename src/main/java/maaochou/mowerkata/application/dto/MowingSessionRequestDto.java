package maaochou.mowerkata.application.dto;

import java.util.List;

public record MowingSessionRequestDto(FieldDto field, List<MowingSessionMowerDto> mowers) {
}
