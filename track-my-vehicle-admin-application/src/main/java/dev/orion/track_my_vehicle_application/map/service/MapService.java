package dev.orion.track_my_vehicle_application.map.service;

import dev.orion.map.client.OSMClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapService {

    private final OSMClient osmClient;

    public Object findLatLngByName(String name) {
        return osmClient.getLatLngByLocationName(name);
    }

    public Object findNameByLatLng(double lat, double lng){
        return osmClient.getLocationNameByLatLng(lat, lng);
    }
}
