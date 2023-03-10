package at.htl;

import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/api/users")
@RolesAllowed({"user"})
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    SecurityIdentity identity;

    @GET
    @Path("/me")
    @NoCache
    public String me() {
        return "Hi " + identity.getPrincipal().getName();
    }

    @GET
    @Path("/admin")
    @NoCache
    @RolesAllowed({"admin"})
    public String admin(){
        return "access granted";
    }
}