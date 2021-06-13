package artur.codes.co2reporter.usecase;

import artur.codes.co2reporter.usecase.io.SensorDataResponseModel;

import java.util.List;

public interface SensorDataPresenter {
    SensorDataResponseModel prepareSuccessView(SensorDataResponseModel responseModel);

    SensorDataResponseModel prepareFailView(String s);

    List<SensorDataResponseModel> prepareSuccessView(List<SensorDataResponseModel> collected);
}
