package by.zelenevsky.dto;

public class GuitarsDto {

    private long serial;
    private String brandName;
    private String modelName;

    public  long getSerial(){
        return this.serial;
    }
    public  String getBrandName(){
        return this.brandName;
    }
    public  String getModelName(){
        return this.modelName;
    }
    public  void setSerial(long value){
        this.serial = value;
    }
    public  void setBrandName(String value){
        this.brandName = value;
    }
    public  void setModelName(String value) {
        this.modelName = value;
    }

}
