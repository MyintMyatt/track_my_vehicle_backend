package dev.orion.map.client;

import dev.orion.map.output.GeocodingResponse;

import java.util.List;

public interface OSMClient {

    GeocodingResponse getLocationNameByLatLng(double lat, double lng);

    List<GeocodingResponse> getLatLngByLocationName(String locationName);

}
