package dev.orion.track_my_vehicle_application.wayAndCar.api.dto.request;

import dev.orion.track_my_vehicle_domain.constant.DistanceUnit;
import dev.orion.track_my_vehicle_domain.way.embeddable.PointInfo;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record WayRequestForm(
        @NotEmpty(message = "{validation.enter} title")
        String title,
        @NotEmpty(message = "{validation.enter} description")
        String description,
        @NotNull(message = "{validation.enter} way start point")
        PointInfo startPoint,
        @NotNull(message = "{validation.enter} way endpoint point")
        PointInfo endPoint,
        @NotNull(message = "{validation.enter} distance unit")
        DistanceUnit distanceUnit,
        @Min(value = 0, message = "{validation.invalid} amount per unit")
        BigDecimal amountPerUnit

) {
}
