package dev.orion.track_my_vehicle_api.tracking.api;

import dev.orion.track_my_vehicle_api.tracking.service.LocationUpdateBroadcastService;
import dev.orion.track_my_vehicle_backend.tracking.dto.request.LocationUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RealTimeCarTrackingController {

    private final LocationUpdateBroadcastService broadcastService;

    @MessageMapping("/track-vehicle")
    public void handleLiveTrack(@Payload LocationUpdate update){
        log.info("Received WebSocket update: {}", update);
        broadcastService.broadcast(update);
    }

    // for tracklet
    @PostMapping("/api/update/locations")
    public void receiveLocation(@RequestBody LocationUpdate update){
        broadcastService.broadcast(update);
    }
}
