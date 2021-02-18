package nl.hu.bep.example.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        packages("nl.hu.bep.example.webservices, nl.hu.bep.example.security");
        register(RolesAllowedDynamicFeature.class);
    }
}
