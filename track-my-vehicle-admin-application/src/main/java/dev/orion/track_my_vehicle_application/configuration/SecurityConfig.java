package dev.orion.track_my_vehicle_application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF for API development
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // 2. Ensure your endpoint is accessible
//                        .requestMatchers("/way/**").authenticated()
                        .anyRequest().permitAll()
                )
                // 3. Enable Basic Auth
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
