package by.zelenevsky.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import by.zelenevsky.dto.*;
import by.zelenevsky.service.GuitarService;

import java.sql.SQLException;
import java.util.List;

@Path("storage")
public class GuitarResource {

    GuitarService guitarService = new GuitarService();
    @GET
    @Path ("/guitars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GuitarsDto> getGuitars() throws SQLException {
        return guitarService.findGuitars();
    }

    @GET
    @Path("/guitars/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModelsDto> findModels(@PathParam ("id") long modelId) throws SQLException {
        return guitarService.findModels(modelId);
    }

    @GET
    @Path ("/models/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ModelsDto findModel(@PathParam ("id") long guitarId) throws SQLException {
        return guitarService.findModel(guitarId);
    }

    @GET
    @Path ("/quantity")
    @Produces(MediaType.APPLICATION_JSON)
    public List<QuantityDto> guitarsQuantity() throws SQLException {
        return guitarService.guitarsQuantity();
    }

    @GET
    @Path ("/sell/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response sellGuitar(@PathParam ("id") long guitarId) throws SQLException {
        return guitarService.sellGuitar(guitarId);
    }
}
