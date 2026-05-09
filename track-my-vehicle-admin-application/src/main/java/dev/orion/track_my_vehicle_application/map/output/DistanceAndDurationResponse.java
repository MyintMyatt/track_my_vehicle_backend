package dev.orion.track_my_vehicle_application.map.output;

public record DistanceAndDurationResponse(
        DurationDto duration,
        double totalDistance,
        String distanceUnit
) {
}
