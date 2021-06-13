package artur.codes.co2reporter.details;

import artur.codes.co2reporter.usecase.SensorDataPresenter;
import artur.codes.co2reporter.usecase.io.SensorDataListResponseModel;
import artur.codes.co2reporter.usecase.io.SensorDataResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class SensorDataRESTFormatter implements SensorDataPresenter {
    @Override
    public SensorDataResponseModel prepareSuccessView(SensorDataResponseModel responseModel) {
        return responseModel;
    }

    @Override
    public SensorDataResponseModel prepareFailView(SensorDataResponseModel responseModel, String s) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, s);
    }

    @Override
    public SensorDataListResponseModel prepareSuccessView(SensorDataListResponseModel response) {
        return response;
    }

    @Override
    public SensorDataListResponseModel prepareFailView(SensorDataListResponseModel response, String s) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, s);
    }


}
