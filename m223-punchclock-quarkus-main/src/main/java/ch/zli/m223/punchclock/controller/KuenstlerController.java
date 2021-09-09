package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Kuenstler;
import ch.zli.m223.punchclock.domain.Kuenstler;
import ch.zli.m223.punchclock.service.KuenstlerService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/kuenstlers")
@Tag(name = "Kuenstlers", description = "Handling of kuenstlers")
public class KuenstlerController {
    @Inject
    KuenstlerService kuenstlerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kuenstler> list() {
        return kuenstlerService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Kuenstler add(Kuenstler  kuenstler) {
        return kuenstlerService.createKuenstler(kuenstler);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kuenstler getSingleKuenstler(@org.jboss.resteasy.annotations.jaxrs.PathParam Long id){
        return kuenstlerService.getKuenstlerById(id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void deleteKuenstler(@PathParam Long id){
        kuenstlerService.delete(id);
    }

    @PUT
    public void update(Kuenstler kuenstler){
        kuenstlerService.update(kuenstler);
    }
}
