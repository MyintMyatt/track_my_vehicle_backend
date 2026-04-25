package dev.orion.track_my_vehicle_domain.way.constant;

import dev.orion.commons.utils.EnumResponse;

public enum CarStatus implements EnumResponse {

    AVAILABLE("active and ready"),
    IN_USE("currently on trip"),
    MAINTENANCE("under service"),
    OUT_OF_SERVICE("temporary operational issue"),
    INACTIVE("no longer used by company (can be reactivated)"),
    DECOMMISSIONED("permanently retired/removed");

    private final String value;

    CarStatus(String v) {
        value = v;
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
