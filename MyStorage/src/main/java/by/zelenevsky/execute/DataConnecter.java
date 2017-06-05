package by.zelenevsky.execute;

import java.sql.*;
import by.zelenevsky.dto.GuitarsDto;

public class DataConnecter {

    private static String url = "jdbc:mysql://localhost:3306/guitars";
    private static String user = "root";
    private static String password = "123456";
    private static Connection connection;
    private static Statement statement;
    public static ResultSet resultSet;

    public static void connect(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from brand, model, availability  where availability.model_id = model.id and model.brand_id = brand.id");
            String gd1="", gd2="";
            int gd3 = 0;
            GuitarsDto gd = new GuitarsDto(gd1, gd2, gd3);
            Executor executor = new Executor();
            while(resultSet.next()) {
                gd.setBrandID(resultSet.getInt(1));
                gd.setBrandName(resultSet.getString(2));
                gd.setModelID(resultSet.getInt(3));
                gd.setMbrandID(resultSet.getInt(4));
                gd.setModelName(resultSet.getString(5));
                gd.setAvailabilityID(resultSet.getInt(6));
                gd.setAmodelID(resultSet.getInt(7));
                gd.setQuantity(resultSet.getInt(8));
                executor.guitarsList.add(GuitarsDto());

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













