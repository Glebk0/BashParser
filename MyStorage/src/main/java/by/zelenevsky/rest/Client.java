package by.zelenevsky.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import by.zelenevsky.dto.GuitarsDto;
import by.zelenevsky.execute.DataConnecter;
import by.zelenevsky.execute.Executor;

@Path("/guitars")
public class Client {

    @GET
    @Path("getMsg")
    public Response getMsg(){
        String[] message = {"","","","","","","","","","","GOgogo","","","",""};
        int i=0;
        GuitarsDto gdto = new GuitarsDto();
        message[i] = gdto.toString();
        return Response.status(200).entity(message[0]).build();
    }

}
