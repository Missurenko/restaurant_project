package edu.bionic.service.impl;

import edu.bionic.dao.MaterialDao;
import edu.bionic.domain.my.Material;
import edu.bionic.service.MaterialService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return materialDao.getAll();
    }

    @Override
    public Material getById(int materialId) {
        return materialDao.getById(materialId).
                orElseThrow(() -> new NotFoundException(String.format("Material this id=%d not found", materialId)));
    }

    @Override
    public Material create(Material material) {
        return materialDao.save(material);
    }

    @Override
    public Material update(Material material) {
        return materialDao.save(material);
    }

    @Override
    public boolean delete(Integer materialId) {
        return materialDao.delete(materialId);
    }

}
