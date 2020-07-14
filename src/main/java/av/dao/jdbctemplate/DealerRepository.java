package av.dao.jdbctemplate;

import av.dao.DealerDao;
import av.domain.Dealer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository("dealerRepositoryJdbcTemplate")
public class DealerRepository implements DealerDao {

    public static final String DEALER_ID = "id";
    public static final String DEALER_NAME = "name";
    public static final String DEALER_ADDRESS = "address";
    public static final String DEALER_CAPACITY = "capacity";
    public static final String DEALER_CREATED = "created";
    public static final String DEALER_CHANGED = "changed";
    public static final String DEALER_YEAR_FOUNDATION = "year_of_foundation";

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DealerRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Dealer> findAll() {
        final String findAllQuery = "select * from m_auto_dealer order by id desc";
        return jdbcTemplate.query(findAllQuery, this::dealerRowMapper);
    }

    private Dealer dealerRowMapper(ResultSet resultSet, int i) throws SQLException {
        Dealer dealer = new Dealer();
        dealer.setId(resultSet.getLong(DEALER_ID));
        dealer.setDealername(resultSet.getString(DEALER_NAME));
        dealer.setAddress(resultSet.getString(DEALER_ADDRESS));
        dealer.setCapacity(resultSet.getLong(DEALER_CAPACITY));
        dealer.setCreated(resultSet.getTimestamp(DEALER_CREATED));
        dealer.setChanged(resultSet.getTimestamp(DEALER_CHANGED));
        dealer.setYear_of_foundation(resultSet.getDate(DEALER_YEAR_FOUNDATION));
        return dealer;
    }


    @Override
    public List<Dealer> search(String searchParam) {
        return null;
    }

    @Override
    public Optional<Dealer> findById(Long dealerId) {
        return Optional.empty();
    }

    @Override
    public Dealer findOne(Long dealerId) {
        return null;
    }

    @Override
    public Dealer save(Dealer dealer) {
        return null;
    }

    @Override
    public Dealer update(Dealer dealer) {
        return null;
    }

    @Override
    public int delete(Dealer dealer) {
        return 0;
    }
}
