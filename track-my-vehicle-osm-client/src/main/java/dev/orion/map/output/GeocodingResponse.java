package dev.orion.map.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeocodingResponse {
    private Double lat;
    @JsonProperty(value = "lon")
    private Double lng;
    private String category;
    private String type;
    @JsonProperty(value = "addresstype")
    private String addressType;
    private String name;

    @JsonProperty(value = "display_name")
    private String displayName;
}
