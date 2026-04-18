package dev.orion.track_my_vehicle_domain.config;

import dev.orion.track_my_vehicle_domain.auditor.Auditor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareConfig implements AuditorAware<Auditor> {
    @Override
    public Optional<Auditor> getCurrentAuditor() {

        var context = SecurityContextHolder.getContext();

        if (null != context){
            var authentication = context.getAuthentication();
            if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated()){

                return Optional.of(
                        Auditor.builder()
                                .userName(authentication.getName())
                                .fullName(Optional.ofNullable(authentication.getDetails()).toString())
                                .build()
                );
            }
        }

        return Optional.empty();
    }
}
