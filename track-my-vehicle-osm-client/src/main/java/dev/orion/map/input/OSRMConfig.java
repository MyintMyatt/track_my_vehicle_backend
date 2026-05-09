package dev.orion.map.input;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.osrm")
public class OSRMConfig {
    private String baseUrl;
    private String service; // route, nearest, trip, etc
    private String version; // v1
    private String profile; // car, bike, foot
}
