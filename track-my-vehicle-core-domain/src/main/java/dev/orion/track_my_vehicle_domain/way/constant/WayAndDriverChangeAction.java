package dev.orion.track_my_vehicle_domain.way.constant;

import dev.orion.commons.utils.EnumResponse;

public enum WayAndDriverChangeAction implements EnumResponse {

     /*
     *  way related enums
     * */
    WAY_REGISTRATION("New Way Registration"),
    WAY_POINT_CHANGED("Way Point Changed"),
    CHARGES_AMOUNT_CHANGED("Charges Amount Changed"),
    WAY_STATUS_CHANGED("Way Status Changed"),
    CAR_CHANGED("Car Changed"),

    /*
    * car related enums
    * */
    CAR_REGISTRATION("New Car Registration"),
    DRIVER_CHANGED("All Driver Info Changed"),
    DRIVER_PHONE_CHANGED("Driver Phone Changed"),

    ;

    private final String name;

    WayAndDriverChangeAction(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getDisplayName() {
        return this.name;
    }
}
