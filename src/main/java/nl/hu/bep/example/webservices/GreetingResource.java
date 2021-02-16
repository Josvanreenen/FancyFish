package nl.hu.bep.example.webservices;

import nl.hu.bep.example.domain.Greeting;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@Path("/sayhello")
public class GreetingResource {

    @GET
    @Path("test")
    @Produces("application/json")
    public Response getGreeting() {
        List<String> allGreetings = Greeting.getAllGreetings();
        if (allGreetings.isEmpty()) return Response
                .status(Response.Status.EXPECTATION_FAILED)
                .entity(new AbstractMap.SimpleEntry<>("message", "There were no greetings in this system available at the time of this request."))
                .build();
        return Response.ok(Greeting.getAllGreetings().get(0)).build();
    }

    @GET
    @Produces("application/json")
    public Response getGreetings() {
        return Response.ok(Greeting.getAllGreetings()).build();
    }

    @PUT
    @Produces("application/json")
    public Response addGreeting(@QueryParam("greeting") String newGreeting){
        boolean succeeded = Greeting.addGreeting(newGreeting);
        if (!succeeded) return Response.status(Response.Status.CONFLICT).build();
        return Response.ok(Greeting.getAllGreetings()).build();
    }

}
