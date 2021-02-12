package nl.hu.bep.example.webservices;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/sayhello")
public class GreetingResource {

    @GET
    @Produces("application/json")
    public String getGreeting(){

        return Json.createObjectBuilder().add("greeting", "Hello World!").build().toString();
    }
}
