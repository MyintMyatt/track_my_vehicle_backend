package dev.orion.track_my_vehicle_application.map.api;

import dev.orion.commons.model.ApiResponse;
import dev.orion.track_my_vehicle_application.map.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ApiResponse<Object> findNameByLatLng(@RequestParam(name = "lat") double lat, @RequestParam(name = "lng") double lng){
        return ApiResponse.success(mapService.findNameByLatLng(lat, lng));
    }
}
