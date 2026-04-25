package dev.orion.track_my_vehicle_domain.way.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driver_info_change_reqeust")
public class DriverInfoChangeRequest extends BaseWayAndDriverInfoChangeRequest{

    @OneToOne(optional = false)
    @JoinColumn(name = "ferry_car_id",referencedColumnName = "id")
    private FerryCar ferryCar;
}
