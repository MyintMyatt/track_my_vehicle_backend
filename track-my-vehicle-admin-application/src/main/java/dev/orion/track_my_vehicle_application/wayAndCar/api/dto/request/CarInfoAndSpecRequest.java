package dev.orion.track_my_vehicle_application.wayAndCar.api.dto.request;

import dev.orion.track_my_vehicle_domain.constant.DistanceUnit;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarInfoAndSpecRequest {

        @NotBlank(message = "{validation.enter} carLicenseNumber")
        private String carLicenseNumber;

        @NotNull(message = "{validation.enter} carLicenseNumberPhoto")
        private MultipartFile carLicenseNumberPhoto;

        @NotBlank(message = "{validation.enter} carModel")
        private String carModel;

        @Min(value = 0, message = "{validation.invalid} capacity")
        private int capacity;

        @Min(value = 0, message = "{validation.invalid} amountPerUnit")
        private BigDecimal amountPerUnit;

        @NotNull(message = "{validation.enter} unit")
        private DistanceUnit unit;

        @NotNull(message = "{validation.enter} carPhoto")
        private MultipartFile carPhoto;
}