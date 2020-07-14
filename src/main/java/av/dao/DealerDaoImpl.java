package av.dao;

import av.domain.Dealer;
import av.exceptions.ResourceNotFoundException;
import av.util.DatabaseConfiguration;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static av.util.DatabaseConfiguration.*;

@Repository
public class DealerDaoImpl implements DealerDao {
    //public static DatabaseConfiguration config = DatabaseConfiguration.getInstance();

    public static final String DEALER_ID = "id";
    public static final String DEALER_NAME = "name";
    public static final String DEALER_ADDRESS = "address";
    public static final String DEALER_CAPACITY = "capacity";
    public static final String DEALER_CREATED = "created";
    public static final String DEALER_CHANGED = "changed";
    public static final String DEALER_YEAR_FOUNDATION = "year_of_foundation";

    private DataSource dataSource;

    public DealerDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Dealer> findAll() {
        final String findAllQuery = "select * from m_auto_dealer order by id desc";

//        String driverName = config.getProperty(DATABASE_DRIVER_NAME);
//        String url = config.getProperty(DATABASE_URL);
//        String login = config.getProperty(DATABASE_LOGIN);
//        String databasePassword = config.getProperty(DATABASE_PASSWORD);

        /*1. Load driver*/
//        try {
//            Class.forName(driverName);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Don't worry:)");
//        }

        List<Dealer> resultList = new ArrayList<>();
        /*2. DriverManager should get connection*/
        //try (Connection connection = DriverManager.getConnection(url, login, databasePassword);
        try (Connection connection = dataSource.getConnection();
                /*3. Get statement from connection*/
             PreparedStatement preparedStatement = connection.prepareStatement(findAllQuery)) {

            /*4. Execute query*/
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                /*6. Add parsed info into collection*/
                resultList.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultList;
    }

    private Dealer parseResultSet(ResultSet resultSet) throws SQLException {
        Dealer dealer = new Dealer();
        /*5. Columns mapping*/
        dealer.setId(resultSet.getLong(DEALER_ID));

        dealer.setAddress(resultSet.getString(DEALER_ADDRESS));

        dealer.setCapacity(resultSet.getLong(DEALER_CAPACITY));
        dealer.setCreated(resultSet.getTimestamp(DEALER_CREATED));
        dealer.setChanged(resultSet.getTimestamp(DEALER_CHANGED));
        //dealer.setYearOfFoundation(resultSet.getDate(DEALER_YEAR_FOUNDATION));
        dealer.setYear_of_foundation(resultSet.getDate(DEALER_YEAR_FOUNDATION));
        dealer.setDealername(resultSet.getString(DEALER_NAME));


        //dealer.setDealername(resultSet.getString(DEALER_NAME));

        return dealer;
    }

    @Override
    public List<Dealer> search(String searchParam) {
        final String findAllQueryForPrepared = "select * from m_auto_dealer where id > ? order by id desc"; //:{имя параметра}    ?

//        String driverName = config.getProperty(DATABASE_DRIVER_NAME);
//        String url = config.getProperty(DATABASE_URL);
//        String login = config.getProperty(DATABASE_LOGIN);
//        String databasePassword = config.getProperty(DATABASE_PASSWORD);

        /*1. Load driver*/
//        try {
//            Class.forName(driverName);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Don't worry:)");
//        }

        List<Dealer> resultList = new ArrayList<>();
        /*2. DriverManager should get connection*/
        //try (Connection connection = DriverManager.getConnection(url, login, databasePassword);
        try (Connection connection = dataSource.getConnection();
                /*3. Get statement from connection*/
             PreparedStatement preparedStatement = connection.prepareStatement(findAllQueryForPrepared)) {

            preparedStatement.setLong(1, Long.parseLong(searchParam));

            /*4. Execute query*/
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                /*6. Add parsed info into collection*/
                resultList.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return resultList;
    }

    @Override
    public Optional<Dealer> findById(Long dealerId) {
        return Optional.ofNullable(findOne(dealerId));
    }

    @Override
    public Dealer findOne(Long dealerId) {
        final String findById = "select * from m_auto_dealer where id = ?";

//        String driverName = config.getProperty(DATABASE_DRIVER_NAME);
//        String url = config.getProperty(DATABASE_URL);
//        String login = config.getProperty(DATABASE_LOGIN);
//        String databasePassword = config.getProperty(DATABASE_PASSWORD);

        /*1. Load driver*/
//        try {
//            Class.forName(driverName);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Don't worry:)");
//        }

        Dealer dealer = null;
        ResultSet resultSet = null;
        /*2. DriverManager should get connection*/
        //try (Connection connection = DriverManager.getConnection(url, login, databasePassword);
        try (Connection connection = dataSource.getConnection();
                /*3. Get statement from connection*/
             PreparedStatement preparedStatement = connection.prepareStatement(findById);
        ) {

            preparedStatement.setLong(1, dealerId);
            /*4. Execute query*/
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                /*6. Add parsed info into collection*/
                dealer = parseResultSet(resultSet);
            } else {
                throw new ResourceNotFoundException("Dealer with id " + dealerId + " not found");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                System.out.println(throwables.getMessage());
            }
        }

        return dealer;
    }

    @Override
    public Dealer save(Dealer dealer) {
        final String insertQuery = "INSERT INTO m_auto_dealer (name, address, capacity, created, changed, year_of_foundation)\n" +
                "VALUES (?, ?, ?, ?, ?, ?)";

//        String driverName = config.getProperty(DATABASE_DRIVER_NAME);
//        String url = config.getProperty(DATABASE_URL);
//        String login = config.getProperty(DATABASE_LOGIN);
//        String databasePassword = config.getProperty(DATABASE_PASSWORD);

        /*1. Load driver*/
//        try {
//            Class.forName(driverName);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Don't worry:)");
//        }

        //try (Connection connection = DriverManager.getConnection(url, login, databasePassword);
             try (Connection connection = dataSource.getConnection();
                /*3. Get statement from connection*/
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
             PreparedStatement lastInsertId = connection.prepareStatement("SELECT currval('m_auto_dealer_id_seq') as last_insert_id;");
        ) {
            preparedStatement.setString(1, dealer.getDealername());
            preparedStatement.setString(2, dealer.getAddress());
            preparedStatement.setLong(3, dealer.getCapacity());
            preparedStatement.setTimestamp(4, dealer.getCreated());
            preparedStatement.setTimestamp(5, dealer.getChanged());
            preparedStatement.setDate(6, dealer.getYear_of_foundation());

            preparedStatement.executeUpdate();

            ResultSet set = lastInsertId.executeQuery();
            set.next();
            long insertedDealerId = set.getInt("last_insert_id");
            return findOne(insertedDealerId);

        } catch (SQLException e) {
            throw new RuntimeException("Some issues in insert operation!", e);
        }
    }

    @Override
    public Dealer update(Dealer dealer) {
        final String updateQuery = "update m_auto_dealer set name = ?, address = ?, capacity = ? " +
                "created = ?, changed = ?, year_of_foundation = ? " +
                "where id = ?";

//        String driverName = config.getProperty(DATABASE_DRIVER_NAME);
//        String url = config.getProperty(DATABASE_URL);
//        String login = config.getProperty(DATABASE_LOGIN);
//        String databasePassword = config.getProperty(DATABASE_PASSWORD);

        /*1. Load driver*/
//        try {
//            Class.forName(driverName);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Don't worry:)");
//        }

        //try (Connection connection = DriverManager.getConnection(url, login, databasePassword);
        try (Connection connection = dataSource.getConnection();
                /*3. Get statement from connection*/
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        ) {
            preparedStatement.setString(1, dealer.getDealername());
            preparedStatement.setString(2, dealer.getAddress());
            preparedStatement.setLong(3, dealer.getCapacity());
            preparedStatement.setTimestamp(4, dealer.getCreated());
            preparedStatement.setTimestamp(5, dealer.getChanged());
            preparedStatement.setDate(6, dealer.getYear_of_foundation());

            preparedStatement.executeUpdate();

            return findOne(dealer.getId());

        } catch (SQLException e) {
            throw new RuntimeException("Some issues in insert operation!", e);
        }
    }

    @Override
    public int delete(Dealer dealer) {
        return 0;
    }

}
