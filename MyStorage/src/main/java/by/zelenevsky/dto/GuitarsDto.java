package by.zelenevsky.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GuitarsDto {

    public  int quantity;
    public  String brandName, modelName;

    public GuitarsDto(){

    }

    public GuitarsDto(int quantity, String brandName, String modelName){
        this.quantity = quantity;
        this.brandName = brandName;
        this.modelName = modelName;
    }

    public  int getQuantity(){
        return this.quantity;
    }
    public  String getBrandName(){
        return this.brandName;
    }
    public  String getModelName(){
        return this.modelName;
    }
    public  void setQuantity(int value){
        this.quantity = value;
    }
    public  void setBrandName(String value){
        this.brandName = value;
    }
    public  void setModelName(String value) {
        this.modelName = value;
    }

    @Override
    public String toString() {
        return "You have " + quantity + " " +
        "of " + brandName + " " + modelName;
    }
}
