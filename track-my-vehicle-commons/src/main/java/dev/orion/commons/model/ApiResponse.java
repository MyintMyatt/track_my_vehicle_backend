package dev.orion.commons.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private boolean success;
    private T payload;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime issueAt;

    public static<T> ApiResponse<T> success(T payload){
        return new ApiResponse<>(true, payload, LocalDateTime.now());
    }

    public static<T> ApiResponse<ErrorResponse> error(ErrorResponse payload){
        return new ApiResponse<ErrorResponse>(false, payload, LocalDateTime.now());
    }
}
