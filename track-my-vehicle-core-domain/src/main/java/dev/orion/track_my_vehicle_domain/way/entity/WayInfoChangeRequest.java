package dev.orion.track_my_vehicle_domain.way.entity;

import jakarta.persistence.*;
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
    @JoinColumns({
            @JoinColumn(name = "way_created_at", referencedColumnName = "requested_at"),
            @JoinColumn(name = "way_all_seq_number", referencedColumnName = "all_seq_number"),
            @JoinColumn(name = "way_one_day_seq", referencedColumnName = "one_day_seq")
    })
    private CarWay carWay;

    @Column(nullable = false)
    private String wayCode;
}
