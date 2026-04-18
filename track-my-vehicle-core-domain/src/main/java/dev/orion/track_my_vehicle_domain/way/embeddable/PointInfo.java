package dev.orion.track_my_vehicle_domain.way.embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PointInfo {

    private String name;
    private double lat;
    private double lng;
}
