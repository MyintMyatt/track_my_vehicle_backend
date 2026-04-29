package dev.orion.track_my_vehicle_application.configuration;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(
        basePackages = {
                "dev.orion.track_my_vehicle_domain"
        }
)
@EnableJpaRepositories(
        basePackages = {
                "dev.orion.track_my_vehicle_domain"
        }
)
public class CoreDomainConfiguration{

}
