package by.zelenevsky.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import by.zelenevsky.dto.*;
import by.zelenevsky.service.GuitarService;

import java.util.ArrayList;
import java.util.List;

@Path("storage")
public class GuitarResource {

    @GET
    @Path ("/guitars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GuitarsDto> getGuitars() {
        return GuitarService.findGuitars();
    }

    @GET
    @Path("/guitars/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModelsDto> findModels(@PathParam ("model") String model){
        return GuitarService.findModels(model);
    }

    @GET
    @Path ("/models/{serialNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public ModelsDto getModel(@PathParam ("serialNumber") long serialNumber){
        return GuitarService.findModel(serialNumber);
    }

    @GET
    @Path ("/quantity")
    @Produces(MediaType.APPLICATION_JSON)
    public List<QuantityDto> guitarsQuantity(){
        return GuitarService.guitarsQuantity();
    }
}