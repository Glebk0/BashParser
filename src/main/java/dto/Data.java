package dto;

public class Data {

    private int brandID, modelID, mbrandID, amodelID, availabilityID, quantity;
    private String brandName, modelName;

    public Data(int id, String name){
        this.brandID = id;
        this.brandName = name;
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
    public void setBrandID(int id){
        this.brandID = id;
    }
    public void setModelID(int id){
        this.modelID = id;
    }
    public void setAmodelID(int id){
        this.amodelID = id;
    }
    public void setMbrandID(int id){
        this.mbrandID = id;
    }
    public void setAvailabilityID(int id){
        this.availabilityID = id;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void setBrandName(String name){
        this.brandName = name;
    }
    public void setModelName(String name){
        this.modelName = name;
    }


}
