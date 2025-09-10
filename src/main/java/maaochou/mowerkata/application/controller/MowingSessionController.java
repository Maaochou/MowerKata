package maaochou.mowerkata.application.controller;

import maaochou.mowerkata.application.dto.MowingSessionRequestDto;
import maaochou.mowerkata.application.dto.MowingSessionResultDto;
import maaochou.mowerkata.application.mapper.MowingSessionMapper;
import maaochou.mowerkata.domain.MowingSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mowingsession")
public class MowingSessionController {

    protected final MowingSessionMapper mowingSessionMapper;

    public MowingSessionController(MowingSessionMapper mowingSessionMapper) {
        this.mowingSessionMapper = mowingSessionMapper;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<MowingSessionResultDto> sendMowingSession(@RequestBody MowingSessionRequestDto mowingSessionDto) {
        MowingSession mowingSession = mowingSessionMapper.toDomain(mowingSessionDto);
        mowingSession.executeMowersInstructions();
        return ResponseEntity.ok(mowingSessionMapper.toDto(mowingSession));
    }
}

