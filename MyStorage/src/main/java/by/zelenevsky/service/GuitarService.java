package by.zelenevsky.service;

import by.zelenevsky.dto.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuitarService {

    private static String url = "jdbc:mysql://localhost:3306/guitars";
    private static String user = "root";
    private static String password = "123456";
    private static Connection connection;
    private static PreparedStatement statement;

    ResultSetHandler handler = new ResultSetHandler<GuitarsDto>() {
        @Override
        public List<GuitarsDto> guitarsHandler(ResultSet rs, List<GuitarsDto> guitarsList) throws SQLException {
            while (rs.next()) {
                GuitarsDto guitarsDto = new GuitarsDto();
                guitarsDto.setId(rs.getLong("id"));
                guitarsDto.setBrandName(rs.getString("brandName"));
                guitarsDto.setModelName(rs.getString("modelName"));
                guitarsDto.setSerialNumber(rs.getLong("serialNumber"));
                guitarsList.add(guitarsDto);
            }
            return guitarsList;
        }
        @Override
        public List<ModelsDto> modelsHandler(ResultSet rs, List<ModelsDto> modelsList) throws SQLException {
            while (rs.next()) {
                ModelsDto modelsDto = new ModelsDto();
                modelsDto.setId(rs.getLong("id"));
                modelsDto.setModelName(rs.getString("modelName"));
                modelsDto.setSerialNumber(rs.getLong("serialNumber"));
                modelsDto.setPrice(rs.getDouble("price"));
                modelsList.add(modelsDto);
            }
            return modelsList;
        }

        @Override
        public ModelsDto modelHandler(ResultSet rs) throws SQLException {
            ModelsDto modelsDto = new ModelsDto();
            while (rs.next()) {
                modelsDto.setId(rs.getLong("id"));
                modelsDto.setModelName(rs.getString("modelName"));
                modelsDto.setSerialNumber(rs.getLong("serialNumber"));
                modelsDto.setPrice(rs.getDouble("price"));
            }
            return modelsDto;
        }

        @Override
        public List<QuantityDto> quantityHandler(ResultSet rs, List<QuantityDto> modelsList) throws SQLException {
            while (rs.next()) {
                QuantityDto quantityDto = new QuantityDto();
                quantityDto.setId(rs.getLong(1));
                quantityDto.setModelName(rs.getString(2));
                quantityDto.setQuantity(rs.getLong(3));
                modelsList.add(quantityDto);
            }
            return modelsList;
        }

    };

    private static Connection getConnection() throws SQLException {
            try {
                connection = DriverManager.getConnection(url, user, password);
                return connection;
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        return connection;
    }

    private static void closeConnection() throws SQLException{
        try{
            connection.close();
            statement.close();
        } catch (SQLException se){}
    }

    public List<GuitarsDto> findGuitars() throws SQLException {
        List <GuitarsDto> guitarsList = new ArrayList<GuitarsDto>();
        getConnection();
        statement = connection.prepareStatement("select a.id id, b.name brandName, m.name modelName, a.serial_number serialNumber " +
                "from brand b, model m, availability a " +
                "where a.model_id = m.id and m.brand_id = b.id and a.status = 1");
        handler.guitarsHandler(statement.executeQuery(), guitarsList);
        System.out.println(guitarsList);
        closeConnection();
        return guitarsList;
    }

    public List<ModelsDto> findModels(long modelId) throws SQLException {
        List<ModelsDto> modelsList = new ArrayList<ModelsDto>();
        getConnection();
        statement = connection.prepareStatement("select a.id id, m.name modelName, a.serial_number serialNumber, a.price price " +
                "from  model m, availability a " +
                "where a.model_id = m.id and  a.status = 1 and m.name = '" +  modelId + "'");
        handler.modelsHandler(statement.executeQuery(), modelsList);
        closeConnection();
        return modelsList;
    }

    public ModelsDto findModel(long serialNumber) throws SQLException{
        ModelsDto modelsDto = new ModelsDto();
        getConnection();
            statement = connection.prepareStatement("select a.id id, m.name modelName, a.serial_number serialNumber, a.price price " +
                    "from  model m, availability a " +
                    "where a.model_id = m.id  and a.serial_number = '" +  serialNumber + "'");
            modelsDto = handler.modelHandler(statement.executeQuery());
        closeConnection();
        return modelsDto;
    }

    public String sellGuitar(long serialNubmer) throws SQLException {
        String result = "The guitar is already sold!";
        getConnection();
            statement = connection.prepareStatement("UPDATE availability SET status = '0' WHERE serial_number = " + serialNubmer + " and status = 1");
            statement.execute();
            result = "The sale was completed successfully!";
        closeConnection();
        return result;
    }

    public List<QuantityDto> guitarsQuantity() throws SQLException {
        List<QuantityDto> modelsList = new ArrayList<QuantityDto>();
        getConnection();
        statement = connection.prepareStatement("SELECT model.id, model.name, count(availability.model_id) " +
                "FROM model, availability " +
                "WHERE availability.model_id = model.ID and status = 1 " +
                "GROUP BY model.id");
        handler.quantityHandler(statement.executeQuery(), modelsList);
        closeConnection();
    return modelsList;
    }
}
