package Lesson7_HomeWork;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class MainApp implements DatabaseRepository {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;


    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:TEST.db");
            statement = connection.createStatement();

            performDropTable();
            createTable();
            insertWeather();
//            readWeatherFromDB();

            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

    }

    private static void createTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather (\n"
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "city TEXT NOT NULL,\n"
                + "localdate TEXT NOT NULL,\n"
                + "text TEXT NOT NULL,\n"
                + "temperature REAL NOT NULL \n"
                + ");");
    }

    String filename;
    String insertWeather = "INSERT INTO weather (city, date, weatherText, temperature) VALUES (?,?,?,?)";

    public MainApp() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    private static void performDropTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS weather");
    }
    private static void insertWeather() throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO weather (city, localdate, weatherText, temperature) " +
                " VALUES (?,?,?,?)");
        for (int i = 0; i < 5; i++); {
//            preparedStatement.setString(1,WeatherData.getCity());
//            preparedStatement.setString(1,WeatherData.getDate());
//            preparedStatement.setString(1,WeatherData.getText());
//            preparedStatement.setDouble(1, WeatherData.getTemperature());
             preparedStatement.addBatch();
            preparedStatement.executeBatch();
        }
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {

        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeather)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherData> getAllSavedData() throws IOException {
        return null;
    }

    @Override
    public void initDB() throws SQLException {

    }

//    private static void readWeatherFromDB() throws SQLException {
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM TEST.db");
//        resultSet.last();
//        resultSet.next();
//        System.out.println(
//                resultSet.getInt(1) + " | " +
//                        resultSet.getString(2) + " | " +
//                        resultSet.getInt(3) + " | "
//        );
//    }
}
