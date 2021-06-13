package artur.codes.co2reporter.usecase.io;

import java.sql.Timestamp;

public class SensorDataResponseModel {

    private String value;
    private String country;
    private String city;
    private String location;
    private Timestamp timestamp;

    public SensorDataResponseModel(String value, String country, String city, String location, Timestamp timestamp) {
        this.value = value;
        this.country = country;
        this.city = city;
        this.location = location;
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }



    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
