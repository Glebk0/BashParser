package execution;


import dto.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path ("/Guitars")
public class MainExecutor {

    private static Set<Data> brandsHashSet;
    private static Iterator<Data> iterator;

    public Set<Data> getBrandsHashSet(){
        return brandsHashSet;
    }
    public static void setBrandsHashSet(Data x){
        brandsHashSet.add(x);
    }

    @GET
    @Path("/deal")
    public static Response main(String[] args){

        brandsHashSet = new HashSet<Data>();
        brandsHashSet.add(new Data (1, "Gibson"));
        iterator = brandsHashSet.iterator();
        String output;
        output = String.valueOf(iterator.next());
        return Response.status(200).entity(output).build();
    }


}
