package dev.orion.map.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OSRMResponse {
    private Double duration;
    private Double distance;
}
