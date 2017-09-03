package edu.bionic.service.impl;

import edu.bionic.dao.ChecksDao;
import edu.bionic.dao.MaterialDao;
import edu.bionic.domain.my.Checks;
import edu.bionic.domain.my.Material;
import edu.bionic.service.CheckService;
import edu.bionic.service.MaterialService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
@Service
public class CheckServiceImpl implements CheckService {

    private ChecksDao checksDao;

    @Autowired
    public CheckServiceImpl(ChecksDao checksDao) {
        this.checksDao = checksDao;
    }


    @Override
    public List<Checks> getAll() {
        return checksDao.getAll();
    }

    @Override
    public Checks getById(int materialId) {
        return checksDao.getById(materialId).
                orElseThrow(() -> new NotFoundException(String.format("Checks this id=%d not found", materialId)));
    }

    @Override
    public Checks create(Checks material) {
        return checksDao.save(material);
    }

    @Override
    public Checks update(Checks material) {
        return checksDao.save(material);
    }

    @Override
    public boolean delete(Integer materialId) {
        return checksDao.delete(materialId);
    }

}
