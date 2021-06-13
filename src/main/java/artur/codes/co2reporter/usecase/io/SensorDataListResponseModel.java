package artur.codes.co2reporter.usecase.io;

import java.sql.Timestamp;
import java.util.List;

public class SensorDataListResponseModel {

    List<SensorDataResponseModel> list;
    public SensorDataListResponseModel() { }

    public SensorDataListResponseModel(List<SensorDataResponseModel> list) {
        this.list = list;
    }

    public List<SensorDataResponseModel> getList() {
        return list;
    }

    public void setList(List<SensorDataResponseModel> list) {
        this.list = list;
    }
}
