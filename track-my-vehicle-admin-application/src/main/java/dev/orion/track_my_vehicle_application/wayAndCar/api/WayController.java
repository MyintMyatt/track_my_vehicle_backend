package dev.orion.track_my_vehicle_application.wayAndCar.api;

import dev.orion.commons.model.ApiResponse;
import dev.orion.track_my_vehicle_application.wayAndCar.api.dto.request.WayRequestForm;
import dev.orion.track_my_vehicle_application.wayAndCar.service.WayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/way")
@RequiredArgsConstructor
public class WayController {

    private final WayService wayService;

    @PostMapping("/create")
    public ApiResponse<?> create(@Validated @RequestBody WayRequestForm form, BindingResult result) {
        return ApiResponse.success("hello");
    }
}
