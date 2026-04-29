package dev.orion.track_my_vehicle_domain.way.entity;

import dev.orion.commons.utils.EnumResponse;
import dev.orion.track_my_vehicle_domain.auditor.Auditor;
import dev.orion.track_my_vehicle_domain.constant.ApprovalStatus;
import dev.orion.track_my_vehicle_domain.way.constant.WayAndDriverChangeAction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "way_and_ferry_car_history_log")
public class WayAndFerryCarHistoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HistorySource historySource;

    @Column(nullable = false)
    private WayAndDriverChangeAction action;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "way_created_at", referencedColumnName = "requested_at"),
            @JoinColumn(name = "way_all_seq_number", referencedColumnName = "all_seq_number"),
            @JoinColumn(name = "way_one_day_seq", referencedColumnName = "one_day_seq")
    })
    private List<CarWay> carWayList;

    @ManyToOne
    @JoinColumn(name = "ferry_car_id",referencedColumnName = "id")
    private List<FerryCar> ferryCarList;

    @Column(columnDefinition = "TEXT")
    private String oldInfo;

    @Column(columnDefinition = "TEXT")
    private String newInfo;

    private ApprovalStatus approvalStatus;

    private String status;

    private String requestedRemark;
    private String rejectedRemark;

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

    public void setStatus(EnumResponse enu){
        this.status = enu.getName();
    }
    public enum HistorySource{
        CAR_WAY, FERRY_CAR
    }
}


