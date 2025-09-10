package maaochou.mowerkata.application.mapper;

import maaochou.mowerkata.application.dto.FieldDto;
import maaochou.mowerkata.application.dto.MowingSessionRequestDto;
import maaochou.mowerkata.application.dto.MowingSessionResultDto;
import maaochou.mowerkata.domain.MowingSession;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

// FIXME figure out mapstruct annotations, or just map manually (This took me too much time)
@Mapper(componentModel = "spring", uses = {MowerMapper.class})
public interface MowingSessionMapper {

    default MowingSession toDomain(MowingSessionRequestDto dto) {
        if (dto == null) return null;

        return toDomain(dto, dto.field());
    }

    MowingSession toDomain(MowingSessionRequestDto mowingSessionDto, @Context FieldDto fieldDto);

    MowingSessionResultDto toDto(MowingSession mowingSession);

}
