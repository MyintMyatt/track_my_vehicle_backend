package dev.orion.track_my_vehicle_domain.way;

import dev.orion.track_my_vehicle_domain.auditor.AuditorEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "car_way")
@Data
public class CarWay extends AuditorEntity {

//    @Id

}
