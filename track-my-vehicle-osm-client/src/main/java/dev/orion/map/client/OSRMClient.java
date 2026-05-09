package dev.orion.map.client;

import dev.orion.map.input.Point;
import dev.orion.map.output.OSRMResponse;

import java.util.List;

public interface OSRMClient {

    OSRMResponse getDistanceAndDuration(List<Point> points);
}
