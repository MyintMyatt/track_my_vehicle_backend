package dev.orion.track_my_vehicle_application.map.api;

import dev.orion.commons.model.ApiResponse;
import dev.orion.map.output.GeocodingResponse;
import dev.orion.track_my_vehicle_application.map.input.Points;
import dev.orion.track_my_vehicle_application.map.service.MapService;
import dev.orion.track_my_vehicle_domain.constant.DistanceUnit;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @GetMapping("lat-lng")
    public ApiResponse<Object> findLatLngByName(@RequestParam(name = "name") String name){
        return ApiResponse.success(mapService.findLatLngByName(name));
    }

    @GetMapping("name")
    public ApiResponse<GeocodingResponse> findNameByLatLng(@RequestParam(name = "lat") double lat, @RequestParam(name = "lng") double lng){
        return ApiResponse.success(mapService.findNameByLatLng(lat, lng));
    }

    @GetMapping("distance-between-points")
    public ApiResponse<Object> getDistanceAndDuration(@Valid @RequestBody Points points, @RequestParam(name = "distance-unit", required = false) DistanceUnit distanceUnit){
        return ApiResponse.success(mapService.getDistanceAndDuration(points, distanceUnit));
    }
}
