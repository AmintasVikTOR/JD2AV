package av.service;

import av.dao.CarsDao;
import av.dao.UserDao;
import av.domain.Cars;
import av.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CarsService {

    private CarsDao carDao;

    public CarsService(@Qualifier("carsRepositoryJdbcTemplate") CarsDao carDao) {
        this.carDao = carDao;
    }

    public Cars findOne(Long carId) {
        return carDao.findOne(carId);
    }
}