package dev.orion.track_my_vehicle_domain.way.constant;

import dev.orion.commons.utils.EnumResponse;

public enum WayStatus  implements EnumResponse {
    PENDING("way request pending"),
    ACTIVE("way is active"),
    INACTIVE("way is inactive"),
    SUSPENDED("way suspended");

    private final String value;

    WayStatus(String value){
        this.value = value;
    }
    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getDisplayName() {
        return this.value;
    }
}
