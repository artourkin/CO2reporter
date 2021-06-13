package artur.codes.co2reporter.domain;

import java.sql.Timestamp;

public class CO2SensorData implements SensorData {
    private String value;
    private String country;
    private String city;
    private String location;
    private Timestamp timestamp;

    public CO2SensorData() {
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
