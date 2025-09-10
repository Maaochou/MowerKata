package maaochou.mowerkata.application.mapper;

import maaochou.mowerkata.application.dto.FieldDto;
import maaochou.mowerkata.application.dto.MowerDto;
import maaochou.mowerkata.application.dto.MowingSessionMowerDto;
import maaochou.mowerkata.domain.Mower;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

// FIXME figure out mapstruct annotations, or just map manually (This took me too much time)
@Mapper(componentModel = "spring")
public interface MowerMapper {

    @Mappings({@Mapping(target = "position.x", source = "position.positionOnXAxis"), @Mapping(target = "position.y", source = "position.positionOnYAxis"), @Mapping(target = "orientation", source = "direction")})
    MowerDto toDto(Mower mower);

    // TODO field being part of the mowing session in the dto and part of the mower in the domain, i had to add a fieldDto as a second parameter
    @Mappings({@Mapping(target = "position.positionOnXAxis", source = "mowingSessionMowerDto.startPosition.x"), @Mapping(target = "position.positionOnYAxis", source = "mowingSessionMowerDto.startPosition.y"), @Mapping(target = "direction", source = "mowingSessionMowerDto.orientation"), @Mapping(target = "field", expression = "java(toDomain(fieldDto))"), @Mapping(target = "field.maxPositionOnXAxis", expression = "java(fieldDto.maxX())"), @Mapping(target = "field.maxPositionOnYAxis", expression = "java(fieldDto.maxY())"),})
    Mower toDomain(MowingSessionMowerDto mowingSessionMowerDto, @Context FieldDto fieldDto);
}
