package dev.orion.track_my_vehicle_domain.way.embeddable;

import dev.orion.track_my_vehicle_domain.constant.DistanceUnit;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarInfoAndSpecification {

    @Column(name = "car_id_card_number", nullable = false)
    private String carIdentityCardNumber;
    private String carModel;
    private int noOfSeats;
    private BigDecimal amount;
    private double distance;
    private DistanceUnit unit;
    private String carPhoto;

    @Embedded
    private DriverInfo driverInfo;
}
