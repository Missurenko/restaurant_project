package edu.bionic.dao.jpa;

import edu.bionic.dao.MaterialDao;
import edu.bionic.domain.my.Material;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by bm on 30.08.17.
 */
@Repository
@Transactional(readOnly = true)
public class JpaMaterialDao implements MaterialDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Material> getAllSortedByName(String name, BigDecimal min, BigDecimal max, String provider, LocalDateTime time,
                                 boolean desc, int offset, int limit) {
       return null;
    }

    @Override
    public List<Material> getCount(String name, BigDecimal min, BigDecimal max, String provider, LocalDateTime time) {
        return null;
    }

    @Override
    public List<Material> getAllSortedByPrice(String name, BigDecimal min, BigDecimal max, String provider, LocalDateTime time, boolean desk, int offset, int limit) {
        return null;
    }
}
