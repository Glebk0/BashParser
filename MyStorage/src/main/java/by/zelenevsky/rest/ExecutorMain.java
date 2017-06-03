package by.zelenevsky.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

@Path("/guitars")
public class ExecutorMain {

    @GET
    @Path("getMsg")
    public Response getMsg(){
        Set<String> brandsHashSet = new HashSet<String>();
        Iterator<String> iterator;
        brandsHashSet.add("1. Cort Primera quantity is: 15");
        iterator = brandsHashSet.iterator();
        String s= "";
        while(iterator.hasNext()){
            s = iterator.next();
        }
        return Response.status(200).entity(s).build();
    }

}
