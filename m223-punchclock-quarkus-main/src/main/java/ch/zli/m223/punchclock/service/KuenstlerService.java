package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Kuenstler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class KuenstlerService {
    @Inject
    private EntityManager entityManager;

    public KuenstlerService() {
    }

    @Transactional
    public Kuenstler createKuenstler(Kuenstler kuenstler) {
        entityManager.persist(kuenstler);
        return kuenstler;
    }

    @SuppressWarnings("unchecked")
    public List<Kuenstler> findAll() {
        var query = entityManager.createQuery("FROM Kuenstler");
        return query.getResultList();
    }

    public Kuenstler getKuenstlerById(Long id){
        return entityManager.find(Kuenstler.class, id);
    }

    @Transactional
    public void delete(Long id){
        Kuenstler kuenstler = getKuenstlerById(id);
        entityManager.remove(kuenstler);
    }

    @Transactional
    public void update(Kuenstler kuenstler){
        entityManager.merge(kuenstler);
    }
}
