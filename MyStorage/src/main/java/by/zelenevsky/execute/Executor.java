package by.zelenevsky.execute;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import by.zelenevsky.dto.*;

public class Executor {

    public static Set<GuitarsDto> guitarsList = new HashSet<GuitarsDto>();
    public static Iterator<GuitarsDto> iterator;

    public static void setGuitarsList(int quantity, String brandName, String modelName){
        guitarsList.add(new GuitarsDto(quantity, brandName, modelName));
    }

    public static void run(){
        DataConnecter connecter = new DataConnecter();
        connecter.connect();
        iterator = guitarsList.iterator();
    }

}
