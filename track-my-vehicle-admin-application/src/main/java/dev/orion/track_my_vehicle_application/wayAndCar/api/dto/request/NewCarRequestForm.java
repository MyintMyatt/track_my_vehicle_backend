package dev.orion.track_my_vehicle_application.wayAndCar.api.dto.request;

import dev.orion.track_my_vehicle_domain.constant.ApprovalStatus;
import dev.orion.track_my_vehicle_domain.way.embeddable.CarInfoAndSpecification;
import dev.orion.track_my_vehicle_domain.way.embeddable.DriverInfo;
import dev.orion.track_my_vehicle_domain.way.entity.CarWay;
import dev.orion.track_my_vehicle_domain.way.entity.FerryCarRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewCarRequestForm {
    @Valid
    @Builder.Default
    CarInfoAndSpecRequest carInfoAndSpecification = new CarInfoAndSpecRequest();
    @Valid
    @Builder.Default
    DriverInfoRequest driverInfo = new DriverInfoRequest();

    public FerryCarRequest toEntity(CarWay carWay) {
        return FerryCarRequest.builder()
                .carInfoAndSpecification(toCarInfoAndSpec())
                .driverInfo(toDriverInfo())
                .carWay(carWay)
                .approvalStatus(ApprovalStatus.Pending)
                .isRequested(true)
                .build();
    }

    public CarInfoAndSpecification toCarInfoAndSpec() {
        return CarInfoAndSpecification.builder()
                .carLicenseNumber(carInfoAndSpecification.getCarLicenseNumber())
                .carModel(carInfoAndSpecification.getCarModel())
                .capacity(carInfoAndSpecification.getCapacity())
                .amountPerUnit(carInfoAndSpecification.getAmountPerUnit())
                .unit(carInfoAndSpecification.getUnit())
                .build();
    }

    public DriverInfo toDriverInfo() {
        return DriverInfo.builder()
                .name(driverInfo.getName())
                .age(driverInfo.getAge())
                .gender(driverInfo.getGender())
                .phone(driverInfo.getPhone())
                .nrc(driverInfo.getNrc())
                .nrcCardPhoto("test")
                .driverLicenseNumber(driverInfo.getDriverLicenseNumber())
                .driverLicensePhoto("test")
                .driverProfilePhoto("test")
                .build();
    }
}
