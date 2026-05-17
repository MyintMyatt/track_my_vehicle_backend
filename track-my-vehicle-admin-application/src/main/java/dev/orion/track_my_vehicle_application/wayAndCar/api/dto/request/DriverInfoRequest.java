package dev.orion.track_my_vehicle_application.wayAndCar.api.dto.request;

import dev.orion.track_my_vehicle_domain.constant.Gender;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverInfoRequest {

    @NotBlank(message = "{validation.enter} name")
    String name;

    @Min(value = 18, message = "{validation.invalid} age")
    int age;

    @NotNull(message = "{validation.enter} gender")
    Gender gender;

    @NotBlank(message = "{validation.enter} phone")
    String phone;

    @NotBlank(message = "{validation.enter} nrc")
    String nrc;

    @NotNull(message = "{validation.enter} nrcCardPhoto")
    MultipartFile nrcCardPhoto;

    @NotBlank(message = "{validation.enter} driverLicenseNumber")
    String driverLicenseNumber;

    @NotNull(message = "{validation.enter} driverLicensePhoto")
    MultipartFile driverLicensePhoto;

    @NotNull(message = "{validation.enter} driverProfilePhoto")
    MultipartFile driverProfilePhoto;

}