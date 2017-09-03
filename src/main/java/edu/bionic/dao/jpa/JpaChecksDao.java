package edu.bionic.dao.jpa;

import edu.bionic.dao.ChecksDao;
import edu.bionic.domain.my.Checks;
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
public class JpaChecksDao implements ChecksDao {

    @PersistenceContext
    private EntityManager entityManager;




    @Override
    public List<Checks> getAll() {
        return entityManager.createQuery("SELECT c FROM Checks c", Checks.class)
                .getResultList();
    }

    @Override
    public Optional<Checks> getById(int checksId) {
        Checks checks = entityManager.find(Checks.class, checksId);
        return Optional.ofNullable(checks);
    }

    @Override
    @Transactional
    public Checks save(Checks checks) {
        if (checks.getId() == null) {
            entityManager.persist(checks);
            return checks;
        } else {
            return entityManager.merge(checks);
        }

    }

    @Override
    @Transactional
    public boolean delete(Integer checksId) {
        Query query = entityManager.createQuery("DELETE FROM Checks m WHERE m.id = :checksId");
        query.setParameter("checksId", checksId);
        return query.executeUpdate() != 0;
    }
}
