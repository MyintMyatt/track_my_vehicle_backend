package dev.orion.track_my_vehicle_domain.way.entity;

import dev.orion.track_my_vehicle_domain.auditor.Auditor;
import dev.orion.track_my_vehicle_domain.constant.ApprovalStatus;
import dev.orion.track_my_vehicle_domain.way.embeddable.CarInfoAndSpecification;
import dev.orion.track_my_vehicle_domain.way.embeddable.DriverInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

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
    @JoinColumns({
            @JoinColumn(name = "fk_way_created_at", referencedColumnName = "requested_at"),
            @JoinColumn(name = "fkway_all_seq_number", referencedColumnName = "all_seq_number"),
            @JoinColumn(name = "fkway_one_day_seq", referencedColumnName = "one_day_seq")
    })
    private CarWay carWay;

    /*
    * for existing way's car change request
    * */
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "fk_way_change_created_at", referencedColumnName = "requested_at"),
            @JoinColumn(name = "fk_way_change_all_seq", referencedColumnName = "all_seq"),
            @JoinColumn(name = "fk_way_change_today_seq", referencedColumnName = "today_seq")
    })
    private WayInfoChangeRequest wayInfoChangeRequest;

    @Embedded
    private CarInfoAndSpecification carInfoAndSpecification;

    @Embedded
    private DriverInfo driverInfo;

    private boolean isRequested;

    private ApprovalStatus approvalStatus;

    private String rejectedReason;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "userName", column = @Column(name = "maker_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "maker_name"))
    })
    private Auditor maker;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "userName", column = @Column(name = "checker_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "checker_name"))
    })
    private Auditor checker;
}
