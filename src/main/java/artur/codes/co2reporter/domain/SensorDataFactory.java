package artur.codes.co2reporter.domain;

import java.sql.Timestamp;

public interface SensorDataFactory {
    SensorData create(String value, String country, String city, String location, Timestamp timestamp);
}
