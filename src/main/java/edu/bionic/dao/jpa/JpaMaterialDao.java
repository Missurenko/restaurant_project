package edu.bionic.dao.jpa;

import edu.bionic.dao.MaterialDao;
import edu.bionic.domain.my.Material;
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
public class JpaMaterialDao implements MaterialDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Material> getAll() {
        return entityManager.createQuery("SELECT m FROM Material m", Material.class)
                .getResultList();
    }

    @Override
    public Optional<Material> getById(int materialId) {
        Material material = entityManager.find(Material.class, materialId);
        return Optional.ofNullable(material);
    }

    @Override
    @Transactional
    public Material save(Material material) {
        if (material.getId() == null) {
            entityManager.persist(material);
            return material;
        } else {
            return entityManager.merge(material);
        }

    }

    @Override
    @Transactional
    public boolean delete(Integer materialId) {
        Query query = entityManager.createQuery("DELETE FROM Material m WHERE m.id = :materialId");
        query.setParameter("materialId", materialId);
        return query.executeUpdate() != 0;
    }
}
