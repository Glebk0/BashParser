package by.zelenevsky.rest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import by.zelenevsky.dto.GuitarsDto;
import by.zelenevsky.execute.DataConnecter;

public class Guitar {

    private static Set<GuitarsDto> guitarsList = new HashSet<GuitarsDto>();
    private static Iterator<GuitarsDto> iterator;

    public static Set<GuitarsDto> getGuitarsList() {
        return guitarsList;
    }
    public static void setGuitarsList(int quantity, String brand, String model){
        guitarsList.add(new GuitarsDto(quantity, brand, model));
    }

    public static GuitarsDto findGuitarByModel(String model) {
        for (GuitarsDto guitar : guitarsList) {
            if (guitar.getModelName() == model) {
                return guitar;
            }
        }
        return null;
    }

    public static boolean deleteGuitarByModel(String model) {
        boolean result = false;
        for (GuitarsDto guitar : guitarsList) {
            if (guitar.getModelName() == model) {
                result = Guitar.guitarsList.remove(guitar);
                return result;
            }
        }
        return result;
    }

    /*
    public static void main(String[] args){
       String[] guitarsMassive = {"", "", "", "", "", "", "", "","","","","","","",""};
        String value = "";
        DataConnecter.connect();
        Set<GuitarsDto> guitars = Guitar.getGuitarsList();
        iterator = guitars.iterator();
        int j =0;
        while (iterator.hasNext()){
            guitarsMassive[j] = String.valueOf(iterator.next());
            j++;
        }
        for (int i = 0; i<15; i++)
            value = value + guitarsMassive[i] + "\n";
        System.out.print(value);
    }*/

}
