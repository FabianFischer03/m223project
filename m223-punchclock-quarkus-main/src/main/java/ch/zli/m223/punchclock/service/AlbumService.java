package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Album;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AlbumService {
    @Inject
    private EntityManager entityManager;

    public AlbumService() {
    }

    @Transactional
    public Album createAlbum(Album album) {
        entityManager.persist(album);
        return album;
    }

    @SuppressWarnings("unchecked")
    public List<Album> findAll() {
        var query = entityManager.createQuery("FROM Album");
        return query.getResultList();
    }

    public Album getAlbumById(Long id){
        return entityManager.find(Album.class, id);
    }

    @Transactional
    public void delete(Long id){
        Album album = getAlbumById(id);
        entityManager.remove(album);
    }

    @Transactional
    public void update(Album album){
        entityManager.merge(album);
    }
}
