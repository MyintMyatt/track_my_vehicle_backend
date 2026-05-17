package dev.orion.track_my_vehicle_application.wayAndCar.api;

import dev.orion.commons.model.ApiResponse;
import dev.orion.commons.model.OperationResult;
import dev.orion.track_my_vehicle_application.wayAndCar.api.dto.request.WayRequestForm;
import dev.orion.track_my_vehicle_application.wayAndCar.service.WayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/way")
@RequiredArgsConstructor
public class WayController {

    private final WayService wayService;

//    @PostMapping(value = "/create"/*, consumes = MediaType.MULTIPART_FORM_DATA_VALUE*/)
//    public ApiResponse<OperationResult<String>> create(
//            @Valid @RequestPart("request") WayRequestForm form,
//            @RequestPart(value = "carLicenseNumberPhoto", required = false) MultipartFile carLicensePhoto,
//            @RequestPart(value = "carPhoto", required = false) MultipartFile carPhoto,
//            @RequestPart(value = "nrcCardPhoto", required = false) MultipartFile nrcPhoto,
//            @RequestPart(value = "driverLicensePhoto", required = false) MultipartFile licensePhoto,
//            @RequestPart(value = "driverProfilePhoto", required = false) MultipartFile profilePhoto,
//            BindingResult result
//    ) {
//        System.err.println(profilePhoto.getOriginalFilename());
//        return ApiResponse.success(wayService.create(form));
//    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ApiResponse<OperationResult<String>> createWay(
            @Valid @ModelAttribute WayRequestForm form
    ) {
        return ApiResponse.success(wayService.create(form));
    }
}
