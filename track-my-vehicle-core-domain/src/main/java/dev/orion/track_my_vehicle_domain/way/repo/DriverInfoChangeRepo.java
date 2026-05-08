package dev.orion.track_my_vehicle_domain.way.repo;

import dev.orion.track_my_vehicle_domain.common.repo.AbstractRepository;
import dev.orion.track_my_vehicle_domain.pk.BaseChangeReqPk;
import dev.orion.track_my_vehicle_domain.way.entity.DriverInfoChangeRequest;

public interface DriverInfoChangeRepo extends AbstractRepository<DriverInfoChangeRequest, BaseChangeReqPk> {
}
