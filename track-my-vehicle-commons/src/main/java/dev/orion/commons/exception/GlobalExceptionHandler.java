package dev.orion.commons.exception;

import dev.orion.commons.constant.ErrorType;
import dev.orion.commons.model.ApiResponse;
import dev.orion.commons.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiResponse<ErrorResponse> handle(ApiValidationException e){
        log.error(e.getMessage());
        return ApiResponse.error(new ErrorResponse(ErrorType.Validation, e.getMessages()));
    }
}
