package dev.orion.track_my_vehicle_domain.way.entity;

import dev.orion.track_my_vehicle_domain.common.BaseChangeRequest;
import dev.orion.track_my_vehicle_domain.way.constant.WayAndDriverChangeAction;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "base_car_and_way_change_request")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseWayAndDriverInfoChangeRequest extends BaseChangeRequest {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WayAndDriverChangeAction changeAction;
}
