package av.dao;

import av.domain.Cars;
import av.domain.User;

import java.util.List;
import java.util.Optional;

public interface CarsDao {
    /*CRUD operations*/
    /*Create = Insert*/
    /*Read = select*/
    /*Update*/
    /*Delete*/
    List<Cars> findAll();

    List<Cars> search(String searchParam);

    Optional<Cars> findById(Long carId);

    Cars findOne(Long carId);

    Cars save(Cars car);

    Cars update(Cars car);

    int delete(Cars car);
}
