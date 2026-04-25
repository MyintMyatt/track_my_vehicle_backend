package dev.orion.track_my_vehicle_domain.way.entity;

import dev.orion.track_my_vehicle_domain.auditor.Auditor;
import dev.orion.track_my_vehicle_domain.constant.ApprovalStatus;
import dev.orion.track_my_vehicle_domain.way.embeddable.CarInfoAndSpecification;
import dev.orion.track_my_vehicle_domain.way.embeddable.DriverInfo;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ferry_car_request")
public class FerryCarRequest {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    /*
     * for new way registration
     * */
    @ManyToOne
    @JoinColumn(name = "way_id", referencedColumnName = "id")
    private List<CarWay> carWayList;

    /*
    * for existing way's car change request
    * */
    @ManyToOne
    @JoinColumn(name = "way_info_change_id", referencedColumnName = "id")
    private List<WayInfoChangeRequest> wayInfoChangeRequestList;

    @Embedded
    private CarInfoAndSpecification carInfoAndSpecification;

    @Embedded
    private DriverInfo driverInfo;

    private boolean isRequested;

    private ApprovalStatus approvalStatus;

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
