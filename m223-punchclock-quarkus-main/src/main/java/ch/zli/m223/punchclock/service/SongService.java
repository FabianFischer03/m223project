package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SongService {
    @Inject
    private EntityManager entityManager;

    public SongService() {
    }

    @Transactional
    public Song createSong(Song song) {
        entityManager.persist(song);
        return song;
    }

    @SuppressWarnings("unchecked")
    public List<Song> findAll() {
        var query = entityManager.createQuery("FROM Song");
        return query.getResultList();
    }

    public Song getSongById(Long id){
        return entityManager.find(Song.class, id);
    }

    @Transactional
    public void delete(Long id){
        Song song = getSongById(id);
        entityManager.remove(song);
    }

    @Transactional
    public void update(Song song){
        entityManager.merge(song);
    }
}
