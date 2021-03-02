package nl.hu.bep.example.webservices;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.bep.example.security.SecurityManager;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap;
import java.util.Calendar;

@PermitAll
@Path("/authentication")
public class AuthenticationResource {

    public static final Key key = MacProvider.generateKey();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username, @FormParam("password") String password){
        try {
            String role = SecurityManager.getInstance().validateLogin(username, password);

            if (role==null) throw new IllegalArgumentException("No user found!");

            String token = createtoken(username, role);

            AbstractMap.SimpleEntry<String, String> jwt = new AbstractMap.SimpleEntry<>("JWT", token);
            return Response.ok(jwt).build();
        }
        catch (JwtException | IllegalArgumentException e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response registerUser(@FormParam("name") String name, @FormParam("username") String username, @FormParam("password") String password){
        try {
            boolean registered = SecurityManager.getInstance().registerUser(name, username, password);
            if(!registered){
                throw new IllegalArgumentException("one or more of the paramaters were probably empty");
            }
            AbstractMap.SimpleEntry<String, String> msg = new AbstractMap.SimpleEntry<>("message", "user was registered succesfully");
            return Response.ok(msg).build();
        }catch (Exception exception){
            AbstractMap.SimpleEntry<String, String> msg = new AbstractMap.SimpleEntry<>("message", "user was not registered succesfully");
            return Response.status(Response.Status.CONFLICT).entity(msg).build();
        }
    }


    private String createtoken(String username, String role) throws JwtException{
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.MINUTE, 30);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expiration.getTime())
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }
}
