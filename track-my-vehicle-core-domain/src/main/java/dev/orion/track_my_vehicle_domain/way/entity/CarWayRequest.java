package dev.orion.track_my_vehicle_domain.way.entity;

import dev.orion.track_my_vehicle_domain.auditor.Auditor;
import dev.orion.track_my_vehicle_domain.auditor.AuditorEntity;
import dev.orion.track_my_vehicle_domain.constant.ApprovalStatus;
import dev.orion.track_my_vehicle_domain.constant.DistanceUnit;
import dev.orion.track_my_vehicle_domain.way.pk.CarWayPK;
import dev.orion.track_my_vehicle_domain.way.embeddable.CarInfoAndSpecification;
import dev.orion.track_my_vehicle_domain.way.embeddable.PointInfo;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "car_way_request")
public class CarWayRequest extends AuditorEntity {

    @Id
    @Embedded
    private CarWayPK id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "start_point_name")),
            @AttributeOverride(name = "lat", column = @Column(name = "start_point_lat")),
            @AttributeOverride(name = "lng", column = @Column(name = "start_point_lng")),
    })
    private PointInfo startPoint;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "Customize Toolbar…")),
            @AttributeOverride(name = "lat", column = @Column(name = "end_point_lat")),
            @AttributeOverride(name = "lng", column = @Column(name = "end_point_lng")),
    })
    private PointInfo endPoint;

    private double totalDistance;

    @Column(nullable = false)
    private DistanceUnit distanceUnit;

    @Embedded
    private CarInfoAndSpecification carInfo;


    private String requestDes;

    @Column(nullable = false)
    private LocalDateTime requestAt;
    private LocalDateTime updateAt;

    private boolean isRequested;

    private ApprovalStatus status;

    private String rejectedReason;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "maker_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "maker_name"))
    })
    private Auditor maker;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "checker_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "checker_name"))
    })
    private Auditor checker;


}
