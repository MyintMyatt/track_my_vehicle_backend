package dev.orion.track_my_vehicle_backend.tracking.service;

import dev.orion.track_my_vehicle_backend.tracking.dto.request.LocationUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationUpdateBroadcastService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public void broadcast(LocationUpdate update){
        log.info("broadcast : {}",update);
        simpMessagingTemplate.convertAndSend("/topic/vehicle", update);
    }
}
