package dev.orion.track_my_vehicle_application.configuration;

import dev.orion.track_my_vehicle_domain.common.repo.AbstractRepositoryImpl;
import dev.orion.track_my_vehicle_domain.config.AuditorAwareConfig;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"dev.orion.track_my_vehicle_domain"})
@EnableJpaRepositories(basePackages = {"dev.orion.track_my_vehicle_domain"}, repositoryBaseClass = AbstractRepositoryImpl.class)
public class CoreDomainConfiguration {

    @Bean
    AuditorAwareConfig auditorAwareConfig() {
        return new AuditorAwareConfig();
    }

}
