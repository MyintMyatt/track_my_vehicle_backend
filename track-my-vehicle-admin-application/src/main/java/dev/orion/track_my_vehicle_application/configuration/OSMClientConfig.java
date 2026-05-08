package dev.orion.track_my_vehicle_application.configuration;

import dev.orion.map.client.OSMClient;
import dev.orion.map.impl.OSMClientDefault;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OSMClientConfig {

    @Value("${osm.base.url}")
    private String OSMBaseUrl;

    @Bean
    OSMClient osmClient(){
        return new OSMClientDefault(OSMBaseUrl);
    }
}
