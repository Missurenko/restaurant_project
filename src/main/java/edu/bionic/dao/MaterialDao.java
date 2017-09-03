package edu.bionic.dao;


import edu.bionic.domain.my.Material;

import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 27.08.17.
 */
public interface MaterialDao {



    List<Material> getAll();

    Optional<Material> getById(int materialId);

    Material save(Material material);

    boolean delete(Integer materialId);
}
