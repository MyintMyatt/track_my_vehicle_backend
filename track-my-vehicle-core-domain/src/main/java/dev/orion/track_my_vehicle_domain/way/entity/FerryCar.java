package dev.orion.track_my_vehicle_domain.way.entity;

import dev.orion.track_my_vehicle_domain.auditor.AuditorEntity;
import dev.orion.track_my_vehicle_domain.way.constant.CarStatus;
import dev.orion.track_my_vehicle_domain.way.embeddable.CarInfoAndSpecification;
import dev.orion.track_my_vehicle_domain.way.embeddable.DriverInfo;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ferry_car")
public class FerryCar extends AuditorEntity {

    @Id
    private String id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "way_created_at", referencedColumnName = "requested_at"),
            @JoinColumn(name = "way_all_seq_number", referencedColumnName = "all_seq_number"),
            @JoinColumn(name = "way_one_day_seq", referencedColumnName = "one_day_seq")
    })
    private CarWay carWay;

    @Column(unique = true)
    private String wayCode;

    @Embedded
    private CarInfoAndSpecification carInfoAndSpecification;

    @Embedded
    private DriverInfo driverInfo;

    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;

    private String referenceCode; // from ferry car request id


}
