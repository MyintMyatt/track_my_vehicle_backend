package dev.orion.track_my_vehicle_application.configuration;

import dev.orion.map.client.OSMClient;
import dev.orion.map.client.OSRMClient;
import dev.orion.map.impl.OSMClientDefault;
import dev.orion.map.impl.OSRMClientDefault;
import dev.orion.map.input.OSRMConfig;
import dev.orion.map.service.OSRMService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {
        OSRMConfig.class
})
@RequiredArgsConstructor
public class MapClientConfig {

    @Value("${app.osm.base-url}")
    private String OSMBaseUrl;

    private final OSRMConfig osrmConfig;

    @Bean
    OSMClient osmClient(){
        return new OSMClientDefault(OSMBaseUrl);
    }

    @Bean
    OSRMClient osrmClient(){
        return new OSRMClientDefault(osrmService());
    }

    @Bean
    OSRMService osrmService(){
        return new OSRMService(osrmConfig);
    }

}
