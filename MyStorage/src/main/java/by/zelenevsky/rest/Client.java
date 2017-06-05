package by.zelenevsky.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/guitars")
public class Client {

    @GET
    @Path("getMsg")
    public Response getMsg(){
        return Response.status(200).entity("").build();
    }

}
