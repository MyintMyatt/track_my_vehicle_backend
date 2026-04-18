package dev.orion.track_my_vehicle_domain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class CoreDomainConfig {

    @Bean
    AuditorAwareConfig auditorAwareConfig(){
        return new AuditorAwareConfig();
    }
}
