package maaochou.mowerkata.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FieldDto(@JsonProperty("max_x") int maxX, @JsonProperty("max_y") int maxY) {
}

