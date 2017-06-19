package by.zelenevsky.service;

import by.zelenevsky.dto.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class GuitarService {

    public List<GuitarsDto> findGuitars() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("guitars");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        ResultSetHandler<List<GuitarsDto>> handler = new BeanListHandler<GuitarsDto>(GuitarsDto.class);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<GuitarsDto> guitarsList;
        guitarsList = queryRunner.query("select a.id id, b.name brandName, m.name modelName, a.serial_number serialNumber " +
                "from brand b, model m, availability a " +
                "where a.model_id = m.id and m.brand_id = b.id and a.status = 1", handler);
        return guitarsList;
    }

    public List<ModelsDto> findModels(long modelId) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("guitars");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        ResultSetHandler<List<ModelsDto>> handler = new BeanListHandler<ModelsDto>(ModelsDto.class);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<ModelsDto> modelsList;
        modelsList = queryRunner.query("select a.id id, m.name modelName, a.serial_number serialNumber, m.price price " +
                "from  model m, availability a " +
                "where a.model_id = m.id and  a.status = 1 and m.id = '" +  modelId + "'", handler);
        return modelsList;
    }

    public List<ModelsDto> findModel(long serialNumber) throws SQLException{
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("guitars");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        ResultSetHandler<List<ModelsDto>> handler = new BeanListHandler<ModelsDto>(ModelsDto.class);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<ModelsDto> modelsList;
        modelsList = queryRunner.query("select a.id id, m.name modelName, a.serial_number serialNumber, m.price price " +
                    "from  model m, availability a " +
                    "where a.model_id = m.id  and a.serial_number = '" +  serialNumber + "'", handler);
        return modelsList;
    }

    public String sellGuitar(long serialNumber) throws SQLException {
        String result = "Already Sold.";
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("guitars");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        QueryRunner queryRunner = new QueryRunner(dataSource);
        if (queryRunner.update("UPDATE availability SET status = '0' " + "WHERE serial_number = " + serialNumber + " and status = 1") == 1){
        result = "Succesfull";}
        return result;
    }

    public List<QuantityDto> guitarsQuantity() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("guitars");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        ResultSetHandler<List<QuantityDto>> handler = new BeanListHandler<QuantityDto>(QuantityDto.class);
        QueryRunner queryRunner = new QueryRunner(dataSource);
        List<QuantityDto> quantityList = new ArrayList<QuantityDto>();
        quantityList = queryRunner.query(
                "SELECT model.id, model.name, count(availability.model_id) " +
                "FROM model, availability " +
                "WHERE availability.model_id = model.ID and status = 1 " +
                "GROUP BY model.id", handler);
        return quantityList;
    }

}
