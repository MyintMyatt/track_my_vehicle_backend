package dev.orion.track_my_vehicle_application.wayAndCar.api.dto.request;

import dev.orion.track_my_vehicle_domain.constant.ApprovalStatus;
import dev.orion.track_my_vehicle_domain.constant.DistanceUnit;
import dev.orion.track_my_vehicle_domain.way.constant.WayStatus;
import dev.orion.track_my_vehicle_domain.way.embeddable.PointInfo;
import dev.orion.track_my_vehicle_domain.way.entity.CarWay;
import dev.orion.track_my_vehicle_domain.way.entity.FerryCarRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WayRequestForm {
    @NotBlank(message = "{validation.enter} title")
    String title;
    @NotBlank(message = "{validation.enter} description")
    String description;
    @NotNull(message = "{validation.enter} way start point")
    PointInfo startPoint;
    @NotNull(message = "{validation.enter} way endpoint point")
    PointInfo endPoint;
    @Min(value = 0, message = "{validation.invalid} total distance")
    Double totalDistance;
    @NotNull(message = "{validation.enter} total distance unit")
    DistanceUnit totalDistanceUnit;
    @NotEmpty(message = "{validation.enter} way points")
    @Valid
    @Builder.Default
    List<PointInfo> wayPoints = new ArrayList<>();
    @NotEmpty(message = "{validation.enter} new car")
    @Valid
    @Builder.Default
    List<NewCarRequestForm> newCarRequest = new ArrayList<>();

    public CarWay toEntity() {
        var way = new CarWay();
        way.setTitle(title);
        way.setDescription(description);
        way.setStartPoint(startPoint);
        way.setEndPoint(endPoint);
        way.setPoints(wayPoints);
        way.setTotalDistance(totalDistance);
        way.setDistanceUnit(totalDistanceUnit);
        way.setRequested(true);
        way.setWayStatus(WayStatus.PENDING);
        way.setApprovalStatus(ApprovalStatus.Pending);

        return way;
    }

    public List<FerryCarRequest> toFerryCarRequest(CarWay way) {
        return newCarRequest.stream().map(e -> e.toEntity(way)).collect(Collectors.toList());
    }
}
