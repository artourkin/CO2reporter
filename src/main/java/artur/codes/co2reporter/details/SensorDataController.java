package artur.codes.co2reporter.details;

import artur.codes.co2reporter.usecase.SensorDataInputBoundary;
import artur.codes.co2reporter.usecase.io.SensorDataListResponseModel;
import artur.codes.co2reporter.usecase.io.SensorDataReadRequestModel;
import artur.codes.co2reporter.usecase.io.SensorDataCreateRequestModel;
import artur.codes.co2reporter.usecase.io.SensorDataResponseModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensordata")
public class SensorDataController {

    final SensorDataInputBoundary inputBoundary;

    public SensorDataController(SensorDataInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }


    @PostMapping("/create")
    SensorDataResponseModel create(@RequestBody SensorDataCreateRequestModel requestModel){
        return inputBoundary.create(requestModel);
    }

    @PostMapping("/read")
    SensorDataListResponseModel read(@RequestBody SensorDataReadRequestModel readRequestModel){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println(name);
        readRequestModel.setUser(name);
        return inputBoundary.read(readRequestModel);
    }
}
