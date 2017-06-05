package by.zelenevsky.dto;

public class GuitarsDto {

    private static int quantity;
    private static String brandName, modelName;

    public GuitarsDto(){

    }

    public GuitarsDto(int quantity, String brandName, String modelName){
        this.quantity = quantity;
        this.brandName = brandName;
        this.modelName = modelName;
    }

    public static int getQuantity(){
        return quantity;
    }
    public static String getBrandName(){
        return brandName;
    }
    public static String getModelName(){
        return modelName;
    }
    public static void setQuantity(int value){
        quantity = value;
    }
    public static void setBrandName(String value){
        brandName = value;
    }
    public static void setModelName(String value) {
        modelName = value;
    }

    @Override
    public String toString() {
        return "You have" + quantity +
        "of" + brandName + modelName + "]";
    }
}
