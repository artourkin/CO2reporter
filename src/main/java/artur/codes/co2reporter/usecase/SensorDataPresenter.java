package artur.codes.co2reporter.usecase;

import artur.codes.co2reporter.usecase.io.SensorDataListResponseModel;
import artur.codes.co2reporter.usecase.io.SensorDataResponseModel;

import java.util.List;

public interface SensorDataPresenter {
    SensorDataResponseModel prepareSuccessView(SensorDataResponseModel responseModel);
    SensorDataResponseModel prepareFailView(SensorDataResponseModel responseModel, String s);

    SensorDataListResponseModel prepareSuccessView(SensorDataListResponseModel response);
    SensorDataListResponseModel prepareFailView(SensorDataListResponseModel response, String s);
}
