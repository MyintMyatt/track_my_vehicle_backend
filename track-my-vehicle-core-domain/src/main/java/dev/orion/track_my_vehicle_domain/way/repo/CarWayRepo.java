package dev.orion.track_my_vehicle_domain.way.repo;

import dev.orion.track_my_vehicle_domain.common.repo.AbstractRepository;
import dev.orion.track_my_vehicle_domain.way.entity.CarWay;
import dev.orion.track_my_vehicle_domain.way.pk.CarWayPK;

public interface CarWayRepo extends AbstractRepository<CarWay, CarWayPK> {
}
