package dev.orion.track_my_vehicle_domain.way.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "way_info_change_reqeust")
public class WayInfoChangeRequest extends BaseWayAndDriverInfoChangeRequest{

    @OneToOne(optional = false)
    private CarWay carWay;

    @Column(nullable = false)
    private String wayCode;
}
