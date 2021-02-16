package nl.hu.bep.example.webservices;

import nl.hu.bep.example.domain.Greeting;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.*;
import java.util.ArrayList;

@Path("/sayhello")
public class GreetingResource {

    @GET
    @Path("test")
    @Produces("application/json")
    public String getGreeting() {
        return Json.createObjectBuilder().add("greeting", Greeting.getAllGreetings().get(0)).build().toString();
    }

    @GET
    @Produces("application/json")
    public String getGreetings() {
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (String g : Greeting.getAllGreetings()){
            jab.add(Json.createObjectBuilder().add("greeting", g).build());
        }
        return jab.build().toString();
    }

    @PUT
    @Produces("application/json")
    public String  addGreeting(@QueryParam("greeting") String newGreeting){
        return Json.createObjectBuilder().add("result", Greeting.addGreeting(newGreeting)).build().toString();
    }

}
