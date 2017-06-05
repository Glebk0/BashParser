package by.zelenevsky.execute;

import java.sql.*;
import java.util.HashSet;
import by.zelenevsky.dto.GuitarsDto;

public class DataConnecter {

    private static String url = "jdbc:mysql://localhost:3306/guitars";
    private static String user = "root";
    private static String password = "123456";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void connect(){
        try {
            Executor executor = new Executor();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select  brand.name, model.name, availability.quantity " +
                    "from brand, model, availability  " +
                    "where availability.model_id = model.id and model.brand_id = brand.id");
            while(resultSet.next()) {
                executor.guitarsList.add(new GuitarsDto(
                        resultSet.getInt(3),
                        resultSet.getString(1),
                        resultSet.getString(2))
                );
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }
}













