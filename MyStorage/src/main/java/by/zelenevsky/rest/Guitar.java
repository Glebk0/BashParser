package by.zelenevsky.rest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import by.zelenevsky.dto.GuitarsDto;

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

   /* public static void main(String[] args){
        Guitar.setGuitarsList(1, "Gibson", "Blue");
        Guitar.setGuitarsList(2, "Cort", "Accord");
        Guitar.setGuitarsList(3, "Boobs", "More Boobs");
*/
}
