package dev.orion.track_my_vehicle_domain.way.embeddable;

import dev.orion.track_my_vehicle_domain.constant.Gender;
import jakarta.persistence.Column;
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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String nrc;

    @Column(nullable = false)
    private String nrcCardPhoto;

    @Column(nullable = false)
    private String driverLicenseNumber;

    @Column(nullable = false)
    private String driverLicensePhoto;

    @Column(nullable = false)
    private String driverProfilePhoto;
}
