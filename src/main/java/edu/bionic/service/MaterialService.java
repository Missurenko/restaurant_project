package edu.bionic.service;


import edu.bionic.domain.Order;
import edu.bionic.domain.Product;
import edu.bionic.domain.my.Material;
import edu.bionic.dto.MaterialSort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
public interface MaterialService {

    List<Material> getAll();

    Material getById(int materialId);

    Material create(Material material);

    void update(Material material);

    void delete(Integer materialId);
}

