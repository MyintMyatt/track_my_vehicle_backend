package dev.orion.map.impl;

import dev.orion.map.client.OSMClient;
import dev.orion.map.output.GeocodingResponse;
import dev.orion.map.service.OSMService;

import java.util.List;

public class OSMClientDefault implements OSMClient {

    private OSMService service;

    public OSMClientDefault(String baseUrl){
        super();
        service = new OSMService(baseUrl);
    }
    @Override
    public GeocodingResponse getLocationNameByLatLng(double lat, double lng) {
        return service.getNameByLatLng(lat, lng);
    }

    @Override
    public List<GeocodingResponse> getLatLngByLocationName(String locationName) {
        return service.getLatLngByName(locationName);
    }
}
