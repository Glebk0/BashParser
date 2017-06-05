package by.zelenevsky.dto;

import java.sql.*;
import by.zelenevsky.execute.*;

public class GuitarsDto {

    private int brandID, modelID, mbrandID, amodelID, availabilityID, quantity;
    private String brandName, modelName;

    public GuitarsDto (String brandName, String modelName, int quantity){
            brandName = this.brandName;
            modelName = this.modelName;
            quantity = this.quantity;
    }

    public void setGuitarsDto() throws SQLException {
        int i=0;
        DataConnecter dc = new DataConnecter();
        dc.connect();
        while (dc.resultSet.next()){
            this.brandID = dc.resultSet.getInt(1);
            this.brandName = dc.resultSet.getString(2);
            this.modelID = dc.resultSet.getInt(3);
            this.mbrandID = dc.resultSet.getInt(4);
            this.modelName = dc.resultSet.getString(5);
            this.availabilityID = dc.resultSet.getInt(6);
            this.amodelID = dc.resultSet.getInt(7);
            this.quantity = dc.resultSet.getInt(8);
            i++;
        }
    }
    public int getBrandID(){
        return this.brandID;
    }
    public int getMbrandID(){
        return this.mbrandID;
    }
    public int getModelID(){
        return this.modelID;
    }
    public int getAmodelID(){
        return this.amodelID;
    }
    public int getAvailabilityID(){
        return this.availabilityID;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public String getBrandName(){
        return this.brandName;
    }
    public String getModelName(){
        return this.modelName;
    }
    public void setBrandID(int value){
        this.brandID = value;
    }
    public void setMbrandID(int value){
        this.mbrandID = value;
    }
    public void setModelID(int value){
        this.modelID = value;
    }
    public void setAmodelID(int value){
        this.amodelID = value;
    }
    public void setAvailabilityID(int value){
        this.availabilityID = value;
    }
    public void setQuantity(int value){
        this.quantity = value;
    }
    public void setBrandName(String value){
        this.brandName = value;
    }
    public void setModelName(String value) {
        this.modelName = value;
    }
}
