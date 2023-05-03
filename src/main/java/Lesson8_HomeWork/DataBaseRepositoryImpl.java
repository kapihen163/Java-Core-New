package Lesson8_HomeWork;

import java.io.IOException;
import java.sql.*;
import java.util.List;


public class DataBaseRepositoryImpl implements DatabaseRepository {

    public void initDB() throws SQLException {
        performDropTable();
        createTable();
    }

    private void createTable() throws SQLException {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather (\n"
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                    + "city TEXT NOT NULL,\n"
                    + "date TEXT NOT NULL,\n"
                    + "weatherText TEXT NOT NULL,\n"
                    + "temperature REAL NOT NULL \n"
                    + ");");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            throw new SQLException("Failure on saving weather object");
        }
    }

    String filename;

    String insertWeather = "INSERT INTO weather (city, date, weatherText, temperature) VALUES (?,?,?,?)";

    public DataBaseRepositoryImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    private void performDropTable() throws SQLException {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS weather");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            throw new SQLException("Failure on saving weather object");
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
            throw new SQLException("Failure on saving weather object");
        }
    }

    @Override
    public List<WeatherData> getAllSavedData() throws IOException {
        return null;
    }

//    private  void readWeatherFromDB() throws SQLException {
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




