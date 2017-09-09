package edu.bionic.dao.jpa;

import edu.bionic.dao.UserRDao;
import edu.bionic.domain.my.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 30.08.17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaUserRDao implements UserRDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAll() {
        return entityManager.createQuery("SELECT m FROM User m", User.class)
                .getResultList();
    }

    @Override
    public Optional<User> getById(int userId) {
        User user = entityManager.find(User.class, userId);
        return Optional.ofNullable(user);
    }

    @Override
    @Transactional
    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
            return user;
        } else {
            return entityManager.merge(user);
        }

    }

    @Override
    @Transactional
    public boolean delete(Integer userId) {
        Query query = entityManager.createQuery("DELETE FROM User m WHERE m.id = :userId");
        query.setParameter("userId", userId);
        return query.executeUpdate() != 0;
    }

    @Override
    public Optional<User> getByEmail(String username) {
       User user = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", username)
                .getSingleResult();
        return Optional.ofNullable(user);
    }
}
