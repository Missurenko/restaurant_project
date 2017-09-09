package edu.bionic.dao;


import edu.bionic.domain.my.Checks;

import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 27.08.17.
 */
public interface ChecksDao {

    List<Checks> getAll();

    Optional<Checks> getById(int checksId);

    Checks save(Checks checks);

    boolean delete(Integer checksId);

    List<Checks> getAllByUser(Integer id);
}
