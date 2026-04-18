package dev.orion.track_my_vehicle_domain.account;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class EmployeeAddressInfo {
    private String country;
    private String city;
    private String township;
    private String ward;
    private String street;
    private String houseNo;
}
