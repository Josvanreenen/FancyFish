package nl.hu.bep.example.webservices;

import nl.hu.bep.example.domain.FancyFishManager;
import nl.hu.bep.example.domain.Greeting;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.List;

@Path("/sayhello")
public class GreetingResource {

    public static final String MESSAGE = "message";

    @GET
    @Path("test")
    @Produces("application/json")
    public Response getGreeting() {
        List<Greeting> allGreetings = FancyFishManager.getInstance().getAllGreetings();
        if (allGreetings.isEmpty()) return Response
                .status(Response.Status.EXPECTATION_FAILED)
                .entity(new AbstractMap.SimpleEntry<>(MESSAGE, "There were no greetings in this system available at the time of this request."))
                .build();
        return Response.ok(new AbstractMap.SimpleEntry<>("greeting", allGreetings.get(0))).build();
    }

    @GET
    @Produces("application/json")
    public Response getGreetings() {
        return Response.ok(FancyFishManager.getInstance().getAllGreetings()).build();
    }

    @PUT
    @Produces("application/json")
    public Response addGreeting(@QueryParam("greeting") String newGreeting){
        boolean succeeded = FancyFishManager.getInstance().addGreeting(newGreeting);
        if (!succeeded) return Response.status(Response.Status.CONFLICT).build();
        return Response.ok(FancyFishManager.getInstance().getAllGreetings()).build();
    }

    @POST
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addGreetingViaForm(@FormParam("greeting") String newGreeting){
        if(!newGreeting.isBlank() && FancyFishManager.getInstance().addGreeting(newGreeting)){
            return Response.ok(new AbstractMap.SimpleEntry<>(MESSAGE, "Added: "+newGreeting)).build();
        }
        return Response.status(Response.Status.NOT_ACCEPTABLE).entity(new AbstractMap.SimpleEntry<>(MESSAGE, "Greeting: "+newGreeting+ " was already present")).build();
    }

}
