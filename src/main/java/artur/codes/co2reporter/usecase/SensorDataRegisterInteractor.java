package artur.codes.co2reporter.usecase;

import artur.codes.co2reporter.domain.SensorData;
import artur.codes.co2reporter.domain.SensorDataFactory;
import artur.codes.co2reporter.usecase.datasource.SensorDataDsRequestModel;
import artur.codes.co2reporter.usecase.datasource.SensorDataDsResponseModel;
import artur.codes.co2reporter.usecase.datasource.SensorDataRegisterDsGateway;
import artur.codes.co2reporter.usecase.io.SensorDataCreateRequestModel;
import artur.codes.co2reporter.usecase.io.SensorDataListResponseModel;
import artur.codes.co2reporter.usecase.io.SensorDataReadRequestModel;
import artur.codes.co2reporter.usecase.io.SensorDataResponseModel;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

class SensorDataRegisterInteractor implements SensorDataInputBoundary {

    final SensorDataRegisterDsGateway sensorDataRegisterDsGateway;
    final SensorDataPresenter sensorDataPresenter;
    final SensorDataFactory sensorDataFactory;

    SensorDataRegisterInteractor(SensorDataRegisterDsGateway sensorDataRegisterDsGateway, SensorDataPresenter sensorDataPresenter, SensorDataFactory sensorDataFactory) {
        this.sensorDataRegisterDsGateway = sensorDataRegisterDsGateway;
        this.sensorDataPresenter = sensorDataPresenter;
        this.sensorDataFactory = sensorDataFactory;
    }

    @Override
    public SensorDataResponseModel create(SensorDataCreateRequestModel requestModel) {

        Timestamp timestamp = new Timestamp(new Date().getTime());
        SensorData sensorData = sensorDataFactory.create(requestModel.getValue(), requestModel.getCountry(),
                requestModel.getCity(), requestModel.getLocation(), timestamp);
        if (null == sensorData.getValue()) {
            return sensorDataPresenter.prepareFailView(new SensorDataResponseModel(), "No sensor data value is reported.");
        }
        LocalDateTime now = LocalDateTime.now();
        SensorDataDsRequestModel sensorDataDsModel = new SensorDataDsRequestModel(sensorData.getValue(),
                sensorData.getCountry(), sensorData.getCity(), sensorData.getLocation(), sensorData.getTimestamp());

        sensorDataRegisterDsGateway.save(sensorDataDsModel);

        SensorDataResponseModel responseModel = new SensorDataResponseModel(sensorData.getValue(),
                sensorData.getCountry(), sensorData.getCity(), sensorData.getLocation(), sensorData.getTimestamp());
        return sensorDataPresenter.prepareSuccessView(responseModel);
    }

    @Override
    public SensorDataListResponseModel read(SensorDataReadRequestModel readRequestModel) {

        SensorDataDsRequestModel sensorDataDsModel = new SensorDataDsRequestModel(null, readRequestModel.getCountry(),
                readRequestModel.getCity(), readRequestModel.getLocation(), null);

        if ("atwien".equalsIgnoreCase(readRequestModel.getUser()) && ! "vienna".equalsIgnoreCase(readRequestModel.getCity()) ) {
            return sensorDataPresenter.prepareFailView(new SensorDataListResponseModel(), "User is not allowed to access the data.");
        }

        List<SensorDataDsResponseModel> read = sensorDataRegisterDsGateway.read(sensorDataDsModel);

        List<SensorDataResponseModel> collected =
                read.stream().map(input -> new SensorDataResponseModel(input.getValue(), input.getCountry(),
                        input.getCity(), input.getLocation(), input.getTimestamp())).collect(Collectors.toList());
        SensorDataListResponseModel response = new SensorDataListResponseModel(collected);
        return sensorDataPresenter.prepareSuccessView(response);

    }
}