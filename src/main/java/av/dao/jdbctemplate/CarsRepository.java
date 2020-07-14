package av.dao.jdbctemplate;

import av.dao.CarsDao;
import av.dao.UserDao;
import av.domain.Cars;
import av.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository("carsRepositoryJdbcTemplate")
public class CarsRepository implements CarsDao {

    public static final String CARS_ID = "id";
    public static final String CARS_model = "model";
    public static final String CARS_GUARANTEE_EXPIRATION_DATE = "guarantee_expiration_date";
    public static final String  CARS_PRICE = "price";
    public static final String CARS_DEALER_ID ="dealer_id";
    public static final String  CARS_USER_ID = "user_id";
    public static final String  CARS_DATE_CAR = "dateCar";


    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public CarsRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Cars> findAll() {
        final String findAllQuery = "select * from m_cars order by id desc";
        return jdbcTemplate.query(findAllQuery, this::carRowMapper);
    }

    private Cars carRowMapper(ResultSet resultSet, int i) throws SQLException {
        Cars car = new Cars();
        car.setId(resultSet.getLong(CARS_ID));
        car.setModel(resultSet.getString(CARS_model));
        car.setGuarantee_expiration_date(resultSet.getDate(CARS_GUARANTEE_EXPIRATION_DATE));
        car.setPrice(resultSet.getDouble(CARS_PRICE));
        car.setDealer_id(resultSet.getLong(CARS_DEALER_ID));
        car.setUser_id(resultSet.getLong(CARS_USER_ID));
        car.setDateCar(resultSet.getDate(CARS_DATE_CAR));

        return car;
    }


    @Override
    public List<Cars> search(String searchParam) {
        return null;
    }

    @Override
    public Optional<Cars> findById(Long userId) {
        return Optional.empty();
    }

    @Override
    public Cars findOne(Long carId) {
        return null;
    }

    @Override
    public Cars save(Cars car) {
        return null;
    }

    @Override
    public Cars update(Cars car) {
        return null;
    }

    @Override
    public int delete(Cars car) {
        return 0;
    }
}
