package dev.orion.track_my_vehicle_application.map.service;

import dev.orion.map.client.OSMClient;
import dev.orion.map.client.OSRMClient;
import dev.orion.track_my_vehicle_application.map.input.Points;
import dev.orion.track_my_vehicle_application.map.output.DistanceAndDurationResponse;
import dev.orion.track_my_vehicle_application.map.output.DurationDto;
import dev.orion.track_my_vehicle_domain.constant.DistanceUnit;
import dev.orion.utils.DistanceCalculationUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class MapService {

    private final OSMClient osmClient;
    private final OSRMClient osrmClient;

    public Object findLatLngByName(String name) {
        return osmClient.getLatLngByLocationName(name);
    }

    public Object findNameByLatLng(double lat, double lng) {
        return osmClient.getLocationNameByLatLng(lat, lng);
    }

    public DistanceAndDurationResponse getDistanceAndDuration(Points points, DistanceUnit expectedUnit) {
        var response = osrmClient.getDistanceAndDuration(points.points());

        if (expectedUnit == null)
            expectedUnit = DistanceUnit.KILO_METER;

        var totalDistance = DistanceCalculationUtils.calculate(response.getDistance(), DistanceUnit.METER, expectedUnit);

        var duration = Duration.ofSeconds(response.getDuration().longValue());
        return new DistanceAndDurationResponse(
                new DurationDto(duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart()),
                totalDistance,
                expectedUnit.getDisplayName()
        );
    }
}
