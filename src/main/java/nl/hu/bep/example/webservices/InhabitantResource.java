package nl.hu.bep.example.webservices;

import nl.hu.bep.example.domain.FancyFishManager;
import nl.hu.bep.example.domain.Inhabitant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;

@Path("inhabitant")
@RolesAllowed("Owner")
public class InhabitantResource {
    private static final Logger LOG = LogManager.getLogger(InhabitantResource.class);
    private static final String MESSAGE = "message";

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
        LOG.debug("lengte is: {}", length);
        double lengthDouble=0;
        try{
            lengthDouble = Double.parseDouble(length);
        }
        catch(Exception e){
            LOG.debug(e.getMessage());
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(new AbstractMap.SimpleEntry<>(MESSAGE, "length was not a double")).build();
        }
            if (FancyFishManager.getInstance().addInhabitant(aquarium, inhabitanttype, name, lengthDouble, color)){
                Inhabitant result = FancyFishManager.getInstance().getInhabitantByName(name);
                if(result!=null){
                    return Response.ok(result).build();
                }
                return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>(MESSAGE, "could not add inhabitant for some unknown reason")).build();
            }

        return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>(MESSAGE, "could not add inhabitant")).build();
    }
}
