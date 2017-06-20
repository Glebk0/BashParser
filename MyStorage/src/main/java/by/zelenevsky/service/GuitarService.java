package by.zelenevsky.service;

import by.zelenevsky.dto.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.ws.rs.core.Response;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class GuitarService {

    private static void setDataSourceParameters(MysqlDataSource dataSource){
        dataSource.setDatabaseName("guitars");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
    }

    private static String findGuitarsQuery = "select d.id id, b.name brandName, m.name modelName, d.serial_number serialNumber " +
            "from brand b, model m, description d " +
            "where d.model_id = m.id and m.brand_id = b.id and d.status = 1";

    private static String findModelsQuery = "select d.id id, m.name modelName, d.serial_number serialNumber, d.type type, d.color color, d.price price " +
            "from  model m, description d " +
            "where d.model_id = m.id and  d.status = 1 and m.id = ?";

    private static String findModelQuery = "select d.id id, m.name modelName, d.serial_number serialNumber, d.type type, d.color color, d.price price " +
            "from  model m, description d " +
            "where d.model_id = m.id and  d.status = 1 and d.id = ?";

    private static String sellGuitarQuery = "UPDATE description SET status = '0' " + "WHERE id = ? and status = 1";

    private static String guitarsQuantityQuery = "SELECT m.id id, b.name brandName, m.name modelName, count(d.model_id) quantity " +
            "FROM model m, brand b, description d " +
            "WHERE d.model_id = m.id and d.status = 1 and b.id = m.brand_id " +
                "GROUP BY m.id";
    
    public List<GuitarsDto> findGuitars() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        setDataSourceParameters(dataSource);
        ResultSetHandler<List<GuitarsDto>> handler = new BeanListHandler<GuitarsDto>(GuitarsDto.class);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<GuitarsDto> guitarsList;
        guitarsList = queryRunner.query(findGuitarsQuery, handler);
        return guitarsList;
    }

    public List<ModelsDto> findModels(long modelId) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        setDataSourceParameters(dataSource);
        ResultSetHandler<List<ModelsDto>> handler = new BeanListHandler<ModelsDto>(ModelsDto.class);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<ModelsDto> modelsList;
        modelsList = queryRunner.query(findModelsQuery, handler, modelId);
        return modelsList;
    }

    public List<ModelsDto> findModel(long guitarId) throws SQLException{
        MysqlDataSource dataSource = new MysqlDataSource();
        setDataSourceParameters(dataSource);
        ResultSetHandler<List<ModelsDto>> handler = new BeanListHandler<ModelsDto>(ModelsDto.class);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<ModelsDto> modelsList;
        modelsList = queryRunner.query(findModelQuery, handler, guitarId);
        return modelsList;
    }

    public Response sellGuitar(long guitarId) throws SQLException {
        String result = "Already Sold.";
        MysqlDataSource dataSource = new MysqlDataSource();
        setDataSourceParameters(dataSource);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        int status = queryRunner.update(sellGuitarQuery, guitarId);
        if (status == 1){
        result = "Succesfull";}
        return Response.status(status).entity(result).build();
    }

    public List<QuantityDto> guitarsQuantity() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        setDataSourceParameters(dataSource);
        ResultSetHandler<List<QuantityDto>> handler = new BeanListHandler<QuantityDto>(QuantityDto.class);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<QuantityDto> quantityList = new ArrayList<QuantityDto>();
        quantityList = queryRunner.query(guitarsQuantityQuery, handler);
        return quantityList;
    }

}
