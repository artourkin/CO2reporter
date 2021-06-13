package artur.codes.co2reporter.details;

import artur.codes.co2reporter.usecase.datasource.SensorDataDsRequestModel;
import artur.codes.co2reporter.usecase.datasource.SensorDataDsResponseModel;
import artur.codes.co2reporter.usecase.datasource.SensorDataRegisterDsGateway;

import java.util.List;
import java.util.stream.Collectors;

public class JpaSensorDataService implements SensorDataRegisterDsGateway {

    final JPASensorDataRepository repository;

    public JpaSensorDataService(JPASensorDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(SensorDataDsRequestModel sensorDataDsModel) {

        SensorDataMapper sensorDataMapper = new SensorDataMapper();

        sensorDataMapper.setValue(sensorDataDsModel.getValue());
        sensorDataMapper.setCity(sensorDataDsModel.getCity());
        sensorDataMapper.setCountry(sensorDataDsModel.getCountry());
        sensorDataMapper.setLocation(sensorDataDsModel.getLocation());
        sensorDataMapper.setTimestamp(sensorDataDsModel.getTimestamp());

        repository.save(sensorDataMapper);
    }

    public List<SensorDataDsResponseModel> read(SensorDataDsRequestModel sensorDataDsRequestModel) {
        List<SensorDataMapper> by = repository.findBy(sensorDataDsRequestModel.getCountry(), sensorDataDsRequestModel.getCity());
        List<SensorDataDsResponseModel> collect = by.stream().map(input -> new SensorDataDsResponseModel(input.getValue(),
                input.getCountry(), input.getCity(),
                input.getLocation(), input.getTimestamp())).collect(Collectors.toList());
        return collect;
    }
}
