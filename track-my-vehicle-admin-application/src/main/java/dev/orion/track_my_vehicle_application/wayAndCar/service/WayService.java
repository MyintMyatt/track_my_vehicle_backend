package dev.orion.track_my_vehicle_application.wayAndCar.service;

import dev.orion.commons.model.OperationResult;
import dev.orion.commons.utils.OperationResultFactory;
import dev.orion.track_my_vehicle_application.wayAndCar.api.dto.request.WayRequestForm;
import dev.orion.track_my_vehicle_domain.keyGenerator.CarWayKeyGenerator;
import dev.orion.track_my_vehicle_domain.way.entity.FerryCarRequest;
import dev.orion.track_my_vehicle_domain.way.repo.CarWayRepo;
import dev.orion.track_my_vehicle_domain.way.repo.FerryCarRequestRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WayService {

    private static final String DOMAIN = "Car Way";

    private final OperationResultFactory resultFactory;
    private final CarWayRepo carWayRepo;
    private final FerryCarRequestRepo ferryCarRequestRepo;
    private final CarWayKeyGenerator keyGenerator;

    public OperationResult<String> create(WayRequestForm form){
        var way = form.toEntity();
        way.setId(keyGenerator.next(LocalDate.now()));

        carWayRepo.saveAndFlush(way);

        List<FerryCarRequest> ferryCarRequestList = form.toFerryCarRequest(way);
        ferryCarRequestRepo.saveAll(ferryCarRequestList);

        return resultFactory.requested( way.getId().code(), DOMAIN);
    }

}
