package artur.codes.co2reporter.domain;

import java.sql.Timestamp;

public class CO2SensorDataFactory implements SensorDataFactory {
    @Override
    public SensorData create(String value, String country, String city, String location, Timestamp timestamp) {
        CO2SensorData co2SensorData = new CO2SensorData();
        co2SensorData.setValue(value);
        co2SensorData.setCity(city);
        co2SensorData.setCountry(country);
        co2SensorData.setLocation(location);
        co2SensorData.setTimestamp(timestamp);
        return co2SensorData;
    }
}
