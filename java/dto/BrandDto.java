package dto;

import javax.jws.WebParam;
import java.sql.*;
import java.util.HashSet;
import java.util.Iterator;

public class BrandDto {

    private static String url = "jdbc:mysql://localhost:3306/guitars";
    private static String user = "root";
    private static String password = "GenerateNewPassword";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static HashSet<String> brandsHashSet = new HashSet<String>();

    public HashSet<String> getBrandsHashSet(){
        return brandsHashSet;
    }

    public static void setBrandsHashSet(String x){
        brandsHashSet.add(x);
    }

    public static void dataConnecter() {
        BrandDto brandDto = new BrandDto();

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select  id, name from brand");
            while (resultSet.next()) {
                setBrandsHashSet(resultSet.getInt(1) + " " + resultSet.getString(2));
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
