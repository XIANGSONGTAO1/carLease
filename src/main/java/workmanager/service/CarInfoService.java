package workmanager.service;

import java.util.Date;

public interface CarInfoService {
    double GetCarValuation(String vinCode,double mileage, Date registration,double condition);

}
