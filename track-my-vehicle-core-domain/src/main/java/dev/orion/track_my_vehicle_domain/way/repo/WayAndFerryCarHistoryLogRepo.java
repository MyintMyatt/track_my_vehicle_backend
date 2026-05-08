package dev.orion.track_my_vehicle_domain.way.repo;

import dev.orion.track_my_vehicle_domain.common.repo.AbstractRepository;
import dev.orion.track_my_vehicle_domain.way.entity.WayAndFerryCarHistoryLog;

import java.util.UUID;

public interface WayAndFerryCarHistoryLogRepo extends AbstractRepository<WayAndFerryCarHistoryLog, UUID> {
}
