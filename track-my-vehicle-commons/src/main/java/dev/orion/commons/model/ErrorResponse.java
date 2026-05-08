package dev.orion.commons.model;

import dev.orion.commons.constant.ErrorType;

import java.util.List;

public record ErrorResponse(
        ErrorType type,
        List<String> messages
) {
    public ErrorResponse(ErrorType type, String message){
       this(type, List.of(message));
    }
}
