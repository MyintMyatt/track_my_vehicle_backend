package dev.orion.track_my_vehicle_domain.constant;

import dev.orion.commons.utils.EnumResponse;

public enum Gender implements EnumResponse {
    Male, Female, Other
    ;

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getDisplayName() {
        return name();
    }
}
