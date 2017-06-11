package by.zelenevsky.execute;

import by.zelenevsky.dto.GuitarsDto;
import by.zelenevsky.rest.Client;

import java.sql.*;

public class DataConnecter {

    private static String url = "jdbc:mysql://localhost:3306/guitars";
    private static String user = "root";
    private static String password = "123456";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void fillList(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select  brand.name, model.name, availability.quantity " +
                    "from brand, model, availability  " +
                    "where availability.model_id = model.id and model.brand_id = brand.id");
            while(resultSet.next()) {
                GuitarsDto gdto = new GuitarsDto();
                gdto.setBrandName(resultSet.getString(1));
                gdto.setModelName(resultSet.getString(2));
                gdto.setSerial(resultSet.getLong(3));
                Client.guitarsList.add(gdto);
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
