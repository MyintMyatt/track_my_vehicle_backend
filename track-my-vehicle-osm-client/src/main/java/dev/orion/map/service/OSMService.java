package dev.orion.map.service;

import dev.orion.map.output.GeocodingResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OSMService extends AbstractOSMService{

    private RestClient restClient;

    public OSMService(String baseUrl) {
        super(baseUrl);
        restClient = RestClient
                .builder()
                .baseUrl(getBaseUrl())
                .build();
    }

    public List<GeocodingResponse> getLatLngByName(String name){
        List<GeocodingResponse> result = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("q", name)
                        .queryParam("polygon_geojson", 1)
                        .queryParam("format", "jsonv2")
                        .queryParam("limit", 1)
                        .build()
                )
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new RuntimeException("Invalid request to OSM map service : " + response.getStatusCode());
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new RuntimeException("OSM Map Server error : " + response.getStatusCode());
                })
                .body(new ParameterizedTypeReference<List<GeocodingResponse>>() {});

        return Objects.requireNonNull(result).isEmpty() ? null : Collections.singletonList(result.getFirst());
    }

    public GeocodingResponse getNameByLatLng(double lat, double lng){
        return  restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/reverse")
                        .queryParam("lat", lat)
                        .queryParam("lon", lng)
                        .queryParam("polygon_geojson", 1)
                        .queryParam("format", "jsonv2")
                        .queryParam("limit", 1)
                        .build()
                )
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new RuntimeException("Invalid request to OSM map service : " + response.getStatusCode());
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new RuntimeException("OSM Map Server error : " + response.getStatusCode());
                })
                .body(GeocodingResponse.class);
    }

}
