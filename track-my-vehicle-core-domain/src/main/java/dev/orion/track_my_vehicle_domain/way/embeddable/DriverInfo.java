package dev.orion.track_my_vehicle_domain.way.embeddable;

import dev.orion.track_my_vehicle_domain.constant.Gender;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverInfo {

    private String name;
    private int age;
    private Gender gender;
    private String idCardNumber;
    private String driverPhoto;
}
