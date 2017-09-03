package edu.bionic.service.impl;

import edu.bionic.dao.MaterialDao;
import edu.bionic.domain.my.Material;
import edu.bionic.dto.MaterialSort;
import edu.bionic.dto.ProductSort;
import edu.bionic.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    private MaterialDao materialDao;

    @Autowired
    public MaterialServiceImpl(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }


    @Override
    public List<Material> getAll() {
        return null;
    }

    @Override
    public List<Material> getCount(String name, BigDecimal min, BigDecimal max,
                                   String provider, LocalDateTime time) {
        return materialDao.getCount(name, min, max, provider, time);
    }

    @Override
    public List<Material> getAll(String name, BigDecimal min, BigDecimal max,
                                 String provider, LocalDateTime time, MaterialSort materialSort, int offset, int limit) {
        List<Material> result = new ArrayList<>();
        switch (materialSort) {
            case NAME_ASC:
            case NAME_DESC:
                result = this.materialDao.getAllSortedByName(name, min, max, provider, time, materialSort == MaterialSort.NAME_DESC, offset, limit);
                break;
            case PRICE_ASC:
            case PRICE_DESC:
                result = this.materialDao.getAllSortedByPrice(name, min, max, provider, time, materialSort == MaterialSort.PRICE_DESC, offset, limit);
                break;
        }
        return result;
    }

    @Override
    public Material getById(int materialId) {
        return null;
    }

    @Override
    public Material create(Material material) {
        return null;
    }

    @Override
    public void update(Material material) {

    }

    @Override
    public void delete(Integer materialId) {

    }

}
