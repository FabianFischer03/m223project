package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Album;
import ch.zli.m223.punchclock.service.AlbumService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/albums")
@Tag(name = "Album", description = "Handling of albums")
public class AlbumController {
    @Inject
    AlbumService albumService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Album> list() {
        return albumService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Album add(Album album) {
        return albumService.createAlbum(album);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Album getSingleAlbum(@org.jboss.resteasy.annotations.jaxrs.PathParam Long id){
        return albumService.getAlbumById(id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void deleteAlbum(@PathParam Long id){
        albumService.delete(id);
    }

    @PUT
    public void update(Album album){
        albumService.update(album);
    }
}
