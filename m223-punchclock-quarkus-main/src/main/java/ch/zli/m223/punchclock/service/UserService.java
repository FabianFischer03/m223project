package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    private EntityManager entityManager;

    public UserService() {
    }

    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        var query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }

    public User getUserById(Long id){
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void delete(Long id){
        User user = getUserById(id);
        entityManager.remove(user);
    }

    @Transactional
    public void update(User user){
        entityManager.merge(user);
    }
}