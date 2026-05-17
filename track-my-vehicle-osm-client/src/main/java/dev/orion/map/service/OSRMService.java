package dev.orion.map.service;

import dev.orion.map.input.OSRMConfig;
import dev.orion.map.input.Point;
import dev.orion.map.output.OSRMResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OSRMService extends AbstractOSRMService {

    private RestClient restClient;

    public OSRMService(OSRMConfig config) {
        super(config);
        restClient = RestClient.builder()
                .baseUrl(getBaseUrl())
                .build();
    }

    @Override
    public OSRMResponse getDistanceAndDuration(List<Point> points) {
        String coordinates = convertToCoordinatesUrlString(points);

        Map<String, Object> result = restClient.get()
                .uri(uriBuilder -> uriBuilder
                                .path("/{service}/{version}/{profile}/{coordinates}")
                                .queryParam("overview", false)
//                        .queryParam("steps", false)
                                .build(
                                        getService(),
                                        getVersion(),
                                        getProfile(),
                                        coordinates
                                )
                )
                .header("Accept-Encoding", "gzip, deflate, br, zstd")
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> {
                    throw new RuntimeException("Invalid request to OSRM  service : " + response.getStatusCode() + response.getStatusText());
                })
                .onStatus(HttpStatusCode::is5xxServerError, (request, response) -> {
                    throw new RuntimeException("OSRM Server error : " + response.getStatusCode());
                })
                .body(new ParameterizedTypeReference<Map<String, Object>>() {
                });

        return result != null ? convertToResponse(result) : new OSRMResponse();

    }

    private String convertToCoordinatesUrlString(List<Point> points) {
        return points.stream()
                .map(point -> point.lng() + "," + point.lat())
                .collect(Collectors.joining(";"));
    }

    private OSRMResponse convertToResponse(Map<String, Object> res){
        var data =  (List<Map<String, Object>>) res.get("routes");
        if (data != null && !data.isEmpty()) {
            Map<String, Object> firstRoute = data.get(0);

            Double duration = firstRoute.get("duration") instanceof Number n ? n.doubleValue() : 0.0;
            Double distance = firstRoute.get("distance") instanceof Number n ? n.doubleValue() : 0.0;

            return new OSRMResponse(duration, distance);
        }
        return new OSRMResponse();
    }
}
