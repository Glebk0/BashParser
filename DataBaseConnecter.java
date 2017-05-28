import javax.jws.WebParam;
import java.sql.*;

public class DataBaseConnecter {

    private static String url = "jdbc:mysql://localhost:3306/guitars";
    private static String user = "root";
    private static String password = "GenerateNewPassword";
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    public static String[] brand = new String[30], model = new String [30];
    public static int[] brand_id = new int[30], model_id = new int[30], Bid = new int[30], Mid = new int[30], Aid = new int[30], quantity = new int [30];
    public static int brandCount=0, modelCount=0, availabilityCount=0;


    public static void getValues(){
        try{
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select  id, name from brand");
            while (resultSet.next()) {
                Bid[brandCount] = resultSet.getInt(1);
                brand[brandCount] = resultSet.getString(2);
                brandCount++;
            }
            resultSet = statement.executeQuery("select  id, brand_id, name from model");
            while (resultSet.next()) {
                Mid[modelCount] = resultSet.getInt(1);
                brand_id[modelCount] = resultSet.getInt(2);
                model[modelCount] = resultSet.getString(3);
                modelCount++;
            }
            resultSet = statement.executeQuery("select  id, model_id, quantity from availability");
            while (resultSet.next()) {
                Aid[availabilityCount] = resultSet.getInt(1);
                model_id[availabilityCount] = resultSet.getInt(2);
                quantity[availabilityCount] = resultSet.getInt(3);
                availabilityCount++;
            }
        }catch(SQLException sqlEx){
            sqlEx.printStackTrace();
        } finally {
            try { connection.close(); } catch(SQLException se) { /*can't do anything */ }
            try { statement.close(); } catch(SQLException se) { /*can't do anything */ }
            try { resultSet.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }
}
