package by.zelenevsky.service;

import by.zelenevsky.dto.GuitarsDto;
import by.zelenevsky.dto.ModelsDto;
import by.zelenevsky.dto.QuantityDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetHandler<T> {

    public List<GuitarsDto> guitarsHandler(ResultSet rs, List<GuitarsDto> guitarsList) throws SQLException;
    public List<ModelsDto> modelsHandler(ResultSet rs, List<ModelsDto> modelsList) throws SQLException;
    public ModelsDto modelHandler(ResultSet rs) throws SQLException;
    public List<QuantityDto> quantityHandler(ResultSet rs, List<QuantityDto> quantityList) throws SQLException;

}
