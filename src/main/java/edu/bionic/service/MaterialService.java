package edu.bionic.service;


import edu.bionic.domain.my.Material;

import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
public interface MaterialService {

    List<Material> getAll();

    Material getById(int materialId);

    Material create(Material material);

    Material update(Material material);

    boolean delete(Integer materialId);
}

