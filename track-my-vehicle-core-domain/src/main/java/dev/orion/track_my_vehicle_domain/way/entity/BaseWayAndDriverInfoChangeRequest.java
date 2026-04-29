package dev.orion.track_my_vehicle_domain.way.entity;

import dev.orion.track_my_vehicle_domain.common.entity.BaseChangeRequest;
import dev.orion.track_my_vehicle_domain.way.constant.WayAndDriverChangeAction;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "base_way_and_driver_info_change_request")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseWayAndDriverInfoChangeRequest extends BaseChangeRequest {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WayAndDriverChangeAction changeAction;
}
