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

    @Column(name = "car_id_card_number", nullable = false, unique = true)
    private String carIdentityCardNumber;

    private String carIdentityCardNumberPhoto;

    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private BigDecimal amountPerUnit;

    @Column(nullable = false)
    private DistanceUnit unit;

    private String carPhoto;

}
