package by.zelenevsky.rest;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.crypto.Data;


import by.zelenevsky.dto.GuitarsDto;
import by.zelenevsky.execute.DataConnecter;

import java.util.Iterator;
import java.util.Set;

@Path("guitar")
public class Client {

    @GET
    @Path ("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllGuitars() {
        String value = "";
        DataConnecter.connect();
        Iterator<GuitarsDto> iterator;
        Set<GuitarsDto> guitars = Guitar.getGuitarsList();
        iterator = guitars.iterator();
        while (iterator.hasNext()){
            value = value + String.valueOf(iterator.next()) + "\n";
        }
        return value;
    }

    @GET
    @Path("GET/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getGuitarByModel(@PathParam("model") String model) {
        String value = "";
        Iterator<GuitarsDto> iterator;
        Guitar.setGuitarsList(1, "Gibson", "Blue");
        Guitar.setGuitarsList(2, "Cort", "Accord");
        Guitar.setGuitarsList(3, "Boobs", "More Boobs");
        GuitarsDto guitar = Guitar.findGuitarByModel(model);
        value = String.valueOf(guitar);
        return value;
    }

    @DELETE
    @Path("DELETE/{model}")
    public void deleteGuitar(@PathParam("model") String model) {
        if (Guitar.deleteGuitarByModel(model)!= true) {
            throw new RuntimeException("can't delete guitar model: " + model);
        }
    }
}
