package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Song;
import ch.zli.m223.punchclock.service.SongService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/songs")
@Tag(name = "Songs", description = "Handling of songs")
public class SongController {
    @Inject
    SongService songService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> list() {
        return songService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Song add(Song song) {
        return songService.createSong(song);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Song getSingleSong(@org.jboss.resteasy.annotations.jaxrs.PathParam Long id){
        return songService.getSongById(id);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void deleteSong(@PathParam Long id){
        songService.delete(id);
    }

    @PUT
    public void update(Song song){
        songService.update(song);
    }
}
