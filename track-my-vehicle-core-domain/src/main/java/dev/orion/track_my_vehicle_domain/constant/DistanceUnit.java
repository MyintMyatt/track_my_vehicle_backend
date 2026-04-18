package dev.orion.track_my_vehicle_domain.constant;

import dev.orion.commons.utils.EnumResponse;

public enum DistanceUnit implements EnumResponse {
    KILO_METER("kilo meter"),
    METER("meter"),
    MILE("mile")
    ;

    private String value;

    DistanceUnit(String value){
        this.value = value;
    }
    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getDisplayName() {
        return value;
    }
}
