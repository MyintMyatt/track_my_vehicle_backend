package dev.orion.track_my_vehicle_domain.way.entity;

import dev.orion.track_my_vehicle_domain.auditor.Auditor;
import dev.orion.track_my_vehicle_domain.auditor.AuditorEntity;
import dev.orion.track_my_vehicle_domain.constant.ApprovalStatus;
import dev.orion.track_my_vehicle_domain.constant.DistanceUnit;
import dev.orion.track_my_vehicle_domain.way.pk.CarWayPK;
import dev.orion.track_my_vehicle_domain.way.constant.WayStatus;
import dev.orion.track_my_vehicle_domain.way.embeddable.PointInfo;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "car_way")
@Data
public class CarWay extends AuditorEntity {

    @EmbeddedId
    private CarWayPK id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(unique = true)
    private String wayCode;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "start_point_name", nullable = false)),
            @AttributeOverride(name = "lat", column = @Column(name = "start_point_lat", nullable = false)),
            @AttributeOverride(name = "lng", column = @Column(name = "start_point_lng", nullable = false)),
    })
    private PointInfo startPoint;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "end_point_name", nullable = false)),
            @AttributeOverride(name = "lat", column = @Column(name = "end_point_lat", nullable = false)),
            @AttributeOverride(name = "lng", column = @Column(name = "end_point_lng", nullable = false)),
    })
    private PointInfo endPoint;

    @Column(nullable = false)
    private double totalDistance;

    private BigDecimal totalAmount;

    @Column(nullable = false)
    private DistanceUnit distanceUnit;

    private BigDecimal amountPerUnit;

    @Column(nullable = false)
    private LocalDateTime requestAt;
    private LocalDateTime updateAt;

    private boolean isRequested;

    private ApprovalStatus approvalStatus;

    private WayStatus wayStatus;

    private String rejectedReason;

    @OneToOne(mappedBy = "carWay", fetch = FetchType.LAZY)
    private FerryCar ferryCar;

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
