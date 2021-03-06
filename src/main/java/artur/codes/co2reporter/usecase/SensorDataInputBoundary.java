package artur.codes.co2reporter.usecase;

import artur.codes.co2reporter.usecase.io.SensorDataCreateRequestModel;
import artur.codes.co2reporter.usecase.io.SensorDataListResponseModel;
import artur.codes.co2reporter.usecase.io.SensorDataResponseModel;
import artur.codes.co2reporter.usecase.io.SensorDataReadRequestModel;

import java.util.List;

public interface SensorDataInputBoundary {
    SensorDataResponseModel create(SensorDataCreateRequestModel requestModel);
    SensorDataListResponseModel read(SensorDataReadRequestModel readRequestModel);
}
