package dev.orion.commons.exception;

import lombok.Getter;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.List;

@Getter
public class ApiValidationException extends RuntimeException {

    private final List<String> messages;

    public ApiValidationException(BindingResult result){
        messages = result.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
    }

}
