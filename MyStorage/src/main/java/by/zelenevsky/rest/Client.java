package by.zelenevsky.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import by.zelenevsky.dto.GuitarsDto;
import by.zelenevsky.execute.DataConnecter;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Path("guitar")
public class Client {

    public static List<GuitarsDto> guitarsList = new ArrayList<GuitarsDto>();

    @GET
    @Path ("connect")
    @Produces(MediaType.APPLICATION_JSON)
    public String getConnection(){
        DataConnecter.fillList();
        return "Connection finished succesfull!";
    }

    @GET
    @Path ("print/guitars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GuitarsDto> printAll() {
        return guitarsList;
    }

    @GET
    @Path ("print/model/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public GuitarsDto printModel(@PathParam ("model") String model){
        GuitarsDto myGuitar = new GuitarsDto();
        for (GuitarsDto guitar : guitarsList){
            myGuitar = guitar;
            if (myGuitar.getModelName() == model)
                return myGuitar;
        }
        return myGuitar;
    }
}
