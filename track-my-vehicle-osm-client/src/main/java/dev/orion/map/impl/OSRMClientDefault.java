package dev.orion.map.impl;

import dev.orion.map.client.OSRMClient;
import dev.orion.map.input.Point;
import dev.orion.map.output.OSRMResponse;
import dev.orion.map.service.AbstractOSRMService;

import java.util.List;

public class OSRMClientDefault implements OSRMClient {

    private final AbstractOSRMService osrmService;

    public OSRMClientDefault(AbstractOSRMService osrmService) {
        this.osrmService = osrmService;
    }

    @Override
    public OSRMResponse getDistanceAndDuration(List<Point> points) {
        return osrmService.getDistanceAndDuration(points);
    }
}
