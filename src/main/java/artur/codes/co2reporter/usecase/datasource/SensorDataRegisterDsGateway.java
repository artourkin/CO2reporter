package artur.codes.co2reporter.usecase.datasource;

import java.util.List;

public interface SensorDataRegisterDsGateway {
    void save(SensorDataDsRequestModel sensorDataDsModel);
    List<SensorDataDsResponseModel> read(SensorDataDsRequestModel sensorDataDsModel);
}
