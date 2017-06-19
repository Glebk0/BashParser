package by.zelenevsky.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    public List<ModelsDto> findModels(@PathParam ("id") long id) throws SQLException {
        return guitarService.findModels(id);
    }

    @GET
    @Path ("/models/{serialNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModelsDto> getModel(@PathParam ("serialNumber") long serialNumber) throws SQLException {
        return guitarService.findModel(serialNumber);
    }

    @GET
    @Path ("/quantity")
    @Produces(MediaType.APPLICATION_JSON)
    public List<QuantityDto> guitarsQuantity() throws SQLException {
        return guitarService.guitarsQuantity();
    }

    @GET
    @Path ("/sell/{serialNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public String sellGuitar(@PathParam ("serialNumber") long serialNumber) throws SQLException {
        return guitarService.sellGuitar(serialNumber);
    }
}
