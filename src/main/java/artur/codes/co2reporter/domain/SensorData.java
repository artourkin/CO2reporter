package artur.codes.co2reporter.domain;

import java.sql.Timestamp;

public interface SensorData {
    String getValue();
    String getCountry();
    String getCity();
    String getLocation();
    Timestamp getTimestamp();
}
