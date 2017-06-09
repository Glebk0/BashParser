package by.zelenevsky.rest;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import by.zelenevsky.dto.GuitarsDto;
import com.google.gson.Gson;

import java.util.Iterator;
import java.util.Set;

@Path("guitar")
public class Client {

    @GET
    @Path ("getAll")
    @Produces("application/json")
    public String getAllGuitars() {
        Guitar.setGuitarsList(1, "Gibson", "Blue");
        Guitar.setGuitarsList(2, "Cort", "Accord");
        Guitar.setGuitarsList(3, "Boobs", "More Boobs");
        Set<GuitarsDto> guitars = Guitar.getGuitarsList();
        Gson gson = new Gson();
        String jasonGuitar = gson.toJson(guitars);
        return jasonGuitar;
    }


    @GET
    @Path("GET/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public  String getGuitarByModel(@PathParam("model") String model) {
        Guitar.setGuitarsList(1, "Gibson", "Blue");
        Guitar.setGuitarsList(2, "Cort", "Accord");
        Guitar.setGuitarsList(3, "Boobs", "More Boobs");
        GuitarsDto guitar = Guitar.findGuitarByModel(model);
        String json = new Gson().toJson(guitar);
        return json;
    }

    @DELETE
    @Path("DELETE/{model}")
    public void deleteGuitar(@PathParam("model") String model) {
        if (Guitar.deleteGuitarByModel(model)!= true) {
            throw new RuntimeException("can't delete guitar model: " + model);
        }
    }
}
