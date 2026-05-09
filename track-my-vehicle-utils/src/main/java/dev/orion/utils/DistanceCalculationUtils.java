package dev.orion.utils;

import dev.orion.track_my_vehicle_domain.constant.DistanceUnit;

public class DistanceCalculationUtils {

    private static final double METER_PER_KILOMETER = 1000.0;
    private static final double METER_PER_MILE = 1609.344;

    public static Double calculate(Double value, DistanceUnit from, DistanceUnit to){

        if (null == to){
            to = DistanceUnit.KILO_METER;
        }

        if (from == to)
            return value;

        double meters = switch (from){
            case METER -> value;
            case KILO_METER -> value * METER_PER_KILOMETER;
            case MILE -> value * METER_PER_MILE;
        };

        return switch (to){
            case METER -> meters;
            case KILO_METER -> meters / METER_PER_KILOMETER;
            case MILE -> meters / METER_PER_MILE;
        };
    }

}
