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
    private static Statement statement;
    private static ResultSet resultSet;

    private static List<GuitarsDto> getGuitars(List<GuitarsDto> guitarsList){
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select availability.id, brand.name, model.name, availability.serial_number " +
                    "from brand, model, availability " +
                    "where availability.model_id = model.id and model.brand_id = brand.id and availability.status = 1");
            while (resultSet.next()) {
                GuitarsDto guitarsDto = new GuitarsDto();
                guitarsDto.setId(resultSet.getLong(1));
                guitarsDto.setBrandName(resultSet.getString(2));
                guitarsDto.setModelName(resultSet.getString(3));
                guitarsDto.setSerialNumber(resultSet.getLong(4));
                guitarsList.add(guitarsDto);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return guitarsList;
    }

    private static List<ModelsDto> getModels(List<ModelsDto> modelsList, String modelName){
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select availability.id, model.name, availability.serial_number, model.price " +
                    "from  model, availability  " +
                    "where availability.model_id = model.id and  availability.status = 1 and model.name = '" +  modelName + "'");
            while (resultSet.next()) {
                ModelsDto modelsDto = new ModelsDto();
                modelsDto.setId(resultSet.getLong(1));
                modelsDto.setModelName(resultSet.getString(2));
                modelsDto.setSerialNumber(resultSet.getLong(3));
                modelsDto.setPrice(resultSet.getDouble(4));
                modelsList.add(modelsDto);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return modelsList;
    }

    private static List<ModelsDto> getModel(List<ModelsDto> modelsList, long serialNumber){
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select availability.id, model.name, availability.serial_number, model.price " +
                    "from  model, availability  " +
                    "where availability.model_id = model.id and availability.serial_number = " + serialNumber);
            while (resultSet.next()) {
                ModelsDto modelsDto = new ModelsDto();
                modelsDto.setId(resultSet.getLong(1));
                modelsDto.setModelName(resultSet.getString(2));
                modelsDto.setSerialNumber(resultSet.getLong(3));
                modelsDto.setPrice(resultSet.getDouble(4));
                modelsList.add(modelsDto);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return modelsList;
    }

    public static List<GuitarsDto> findGuitars(){
        List<GuitarsDto> guitarsList = new ArrayList<GuitarsDto>();
        getGuitars(guitarsList);
        return guitarsList;
    }

    public static ModelsDto findModel(long serialNumber){
        List<ModelsDto> modelsList = new ArrayList<ModelsDto>();
        getModel(modelsList, serialNumber);
        ModelsDto myModel = new ModelsDto();
        for (ModelsDto guitar : modelsList){
            myModel = guitar;
            if (myModel.getSerialNumber() == serialNumber)
                return myModel;
        }
        return myModel;
    }

    public static List<ModelsDto> findModels(String modelName){
        List<ModelsDto> modelsList = new ArrayList<ModelsDto>();
        getModels(modelsList, modelName);
        return modelsList;
    }

    public static String sellGuitar(long serialNubmer){
        String result = "Not Sold!";
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.execute("UPDATE availability SET status = '0' WHERE availability.serialNumber = " + serialNubmer + ";");
            result = "Sold!";
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return result;
    }

    public static List<QuantityDto> guitarsQuantity(){
        List<QuantityDto> modelsList = new ArrayList<QuantityDto>();
        try{
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT model.id, model.name, count(availability.model_id) " +
                    "FROM model, availability " +
                    "WHERE availability.model_id = model.ID and status = 1 " +
                    "GROUP BY model.id");
            while (resultSet.next()) {
                QuantityDto quantityDto = new QuantityDto();
                quantityDto.setId(resultSet.getLong(1));
                quantityDto.setModelName(resultSet.getString(2));
                quantityDto.setQuantity(resultSet.getLong(3));
                modelsList.add(quantityDto);
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        finally {
        try {
            connection.close();
        } catch (SQLException se) { /*can't do anything */ }
    }
    return modelsList;
    }

}