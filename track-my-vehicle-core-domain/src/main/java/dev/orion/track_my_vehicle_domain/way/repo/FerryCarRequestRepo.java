package dev.orion.track_my_vehicle_domain.way.repo;

import dev.orion.track_my_vehicle_domain.common.repo.AbstractRepository;
import dev.orion.track_my_vehicle_domain.way.entity.FerryCarRequest;

import java.util.UUID;

public interface FerryCarRequestRepo extends AbstractRepository<FerryCarRequest, UUID> {
}
