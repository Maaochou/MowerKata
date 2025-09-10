package maaochou.mowerkata.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import maaochou.mowerkata.application.dto.MowerDto;
import maaochou.mowerkata.application.dto.MowingSessionResultDto;
import maaochou.mowerkata.application.dto.PositionDto;
import maaochou.mowerkata.application.mapper.MowerMapperImpl;
import maaochou.mowerkata.application.mapper.MowingSessionMapperImpl;
import maaochou.mowerkata.domain.Direction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest({MowingSessionController.class})
@Import({MowingSessionMapperImpl.class,
        MowerMapperImpl.class,})
public class MowingSessionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void mowing_session_with_two_mowers_executes_instructions_test() throws Exception {

        // Given
        // TODO should i test with a string payload or a DTO that jackson transforms into a string?
        String mowingSessionPayloadSent = """
                {
                    "field": {"max_x": 5,"max_y": 5},
                    "mowers": [
                    {
                        "id": "mower1",
                        "start_position": {"x": 1,"y": 2},
                        "orientation": "N",
                        "instructions": ["G","A","G","A","G","A","G","A","A"]
                    },
                    {
                        "id": "mower2",
                        "start_position": {"x": 3,"y": 3},
                        "orientation": "E",
                        "instructions": ["A","A","D","A","A","D","A","D","D","A"]
                    }]
                }
                """;

        MowingSessionResultDto expectedMowerSessionResultDto = new MowingSessionResultDto(List.of(new MowerDto("mower1", new PositionDto(1, 3), Direction.NORTH), new MowerDto("mower2", new PositionDto(5, 1), Direction.EAST)));
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedMowerSessionResultDtoString = objectMapper.writeValueAsString(expectedMowerSessionResultDto);

        // When Then
        mockMvc.perform(MockMvcRequestBuilders.post("/mowingsession").contentType(MediaType.APPLICATION_JSON).content(mowingSessionPayloadSent)).andExpect(content().json(expectedMowerSessionResultDtoString));
    }
}
