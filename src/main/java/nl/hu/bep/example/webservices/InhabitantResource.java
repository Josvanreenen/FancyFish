package nl.hu.bep.example.webservices;

import nl.hu.bep.example.domain.FancyFishManager;
import nl.hu.bep.example.domain.Inhabitant;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;

@Path("inhabitant")
@RolesAllowed("Owner")
public class InhabitantResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInhabitants(){
        return Response.ok(FancyFishManager.getInstance().getAllInhabitants()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response addInhabitantToAquarium(@FormParam("aquarium") String aquarium,
                                            @FormParam("inhabitanttype") String inhabitanttype,
                                            @FormParam("name") String name,
                                            @FormParam("length") String length,
                                            @FormParam("color") String color){
        System.out.println("lengte is: "+length);
        double lengthDouble=0;
        try{
            lengthDouble = Double.parseDouble(length);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(new AbstractMap.SimpleEntry<>("message", "length was not a double")).build();
        }
            if (FancyFishManager.getInstance().addInhabitant(aquarium, inhabitanttype, name, lengthDouble, color)){
                Inhabitant result = FancyFishManager.getInstance().getInhabitantByName(name);
                if(result!=null){
                    return Response.ok(result).build();
                }
                return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("message", "could not add inhabitant for some unknown reason")).build();
            }

        return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("message", "could not add inhabitant")).build();
    }
}
