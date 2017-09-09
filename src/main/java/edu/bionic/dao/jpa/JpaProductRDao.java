package edu.bionic.dao.jpa;

import edu.bionic.dao.ProductRDao;
import edu.bionic.domain.my.Category;
import edu.bionic.domain.my.Product;
import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 30.08.17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaProductRDao implements ProductRDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> getAll() {
        return entityManager.createQuery("SELECT m FROM Product m", Product.class)
                .getResultList();
    }

    @Override
    public Optional<Product> getById(int productId) {
        Product product = entityManager.find(Product.class, productId);
        return Optional.ofNullable(product);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
            return product;
        } else {
            return entityManager.merge(product);
        }

    }

    @Override
    @Transactional
    public boolean delete(Integer productId) {
        Query query = entityManager.createQuery("DELETE FROM Product m WHERE m.id = :productId");
        query.setParameter("productId", productId);
        return query.executeUpdate() != 0;
    }


    @Override
    public int getCount(Category categoty, String name) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(p) FROM Product p " +
                "WHERE (:category is null or p.category = :category) " +
                "AND p.name LIKE :name ", Long.class);
        query.setParameter("category", categoty);
        query.setParameter("name", StringUtil.isEmpty(name) ? "%" : "%" + name + "%");

        return query.getSingleResult().intValue();
    }

    @Override
    public List<Product> getAll(Category categoty, String name, int offset, int limit) {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p " +
                "WHERE (:category is null or p.category = :category) " +
                "AND p.name LIKE :name " +
                "order by p.name", Product.class);
        query.setParameter("category", categoty);
        query.setParameter("name", StringUtil.isEmpty(name) ? "%" : "%" + name + "%");
        query.setMaxResults(limit);
        query.setFirstResult(offset);
        return query.getResultList();
    }
}
