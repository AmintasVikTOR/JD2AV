package av.dao;

import av.domain.Dealer;
import av.util.DatabaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static av.util.DatabaseConfiguration.*;

public class DealerDaoImpl implements DealerDao {
    public static DatabaseConfiguration config = DatabaseConfiguration.getInstance();

    public static final String DEALER_ID = "id";
    public static final String DEALER_NAME = "name";
    public static final String DEALER_ADDRESS = "address";
    public static final String DEALER_CAPACITY = "capacity";
    public static final String DEALER_CREATED = "created";
    public static final String DEALER_CHANGED = "changed";
    public static final String DEALER_YEAR_FOUNDATION = "year_of_foundation";

    @Override
    public List<Dealer> findAll() {
        final String findAllQuery = "select * from m_auto_dealer order by id desc";

        String driverName = config.getProperty(DATABASE_DRIVER_NAME);
        String url = config.getProperty(DATABASE_URL);
        String login = config.getProperty(DATABASE_LOGIN);
        String databasePassword = config.getProperty(DATABASE_PASSWORD);

        /*1. Load driver*/
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Don't worry:)");
        }

        List<Dealer> resultList = new ArrayList<>();
        /*2. DriverManager should get connection*/
        try (Connection connection = DriverManager.getConnection(url, login, databasePassword);
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

        String driverName = config.getProperty(DATABASE_DRIVER_NAME);
        String url = config.getProperty(DATABASE_URL);
        String login = config.getProperty(DATABASE_LOGIN);
        String databasePassword = config.getProperty(DATABASE_PASSWORD);

        /*1. Load driver*/
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Don't worry:)");
        }

        List<Dealer> resultList = new ArrayList<>();
        /*2. DriverManager should get connection*/
        try (Connection connection = DriverManager.getConnection(url, login, databasePassword);
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

}
