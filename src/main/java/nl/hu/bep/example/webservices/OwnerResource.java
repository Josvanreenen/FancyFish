package nl.hu.bep.example.webservices;

import nl.hu.bep.example.domain.FancyFishManager;
import nl.hu.bep.example.domain.Owner;
import nl.hu.bep.example.security.MyUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.AbstractMap;

@Path("/owner")
public class OwnerResource {
    private static final Logger LOG = LogManager.getLogger(OwnerResource.class);

    @GET
    @RolesAllowed("Owner")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOwner(@Context SecurityContext sc){
        try {
            String ownerName = ((MyUser) sc.getUserPrincipal()).getOwnerName();
            LOG.info("Owner name is {}", ownerName);
            Owner thisOwner = FancyFishManager.getInstance().getOwnerByName(ownerName);
            if (thisOwner==null) {
                LOG.error("owner was null");
                throw new NullPointerException("no owner found with that name");
            }
            return Response.ok(thisOwner).build();
        }
        catch (Exception exception){
            return Response.status(Response.Status.NOT_FOUND).entity(new AbstractMap.SimpleEntry<>("message", "No Owner associated with this user ? ? ? ")).build();
        }
    }
}
