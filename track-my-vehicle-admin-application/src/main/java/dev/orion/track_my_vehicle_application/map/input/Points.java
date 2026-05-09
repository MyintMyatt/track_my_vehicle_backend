package dev.orion.track_my_vehicle_application.map.input;

import dev.orion.map.input.Point;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record Points(
        @NotEmpty(message = "{validation.enter} points")
        List<Point> points
) {
}
