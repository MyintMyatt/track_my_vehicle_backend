package dev.orion.map.service;

import dev.orion.map.input.OSRMConfig;
import dev.orion.map.input.Point;
import dev.orion.map.output.OSRMResponse;

import java.util.List;

public abstract class AbstractOSRMService {

    private final OSRMConfig config;

    public AbstractOSRMService(OSRMConfig osrmConfig) {
        this.config = osrmConfig;
    }

    protected String getBaseUrl() {
        return this.config.getBaseUrl();
    }

    protected String getService() {
        return this.config.getService();
    }

    protected String getVersion() {
        return this.config.getVersion();
    }

    protected String getProfile(){
        return this.config.getProfile();
    }

    public abstract OSRMResponse getDistanceAndDuration(List<Point> points);
}
