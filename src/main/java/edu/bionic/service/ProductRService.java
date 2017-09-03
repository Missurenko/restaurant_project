package edu.bionic.service;


import edu.bionic.domain.my.Material;
import edu.bionic.domain.my.Product;

import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
public interface ProductRService {

    List<Product> getAll();

    Product getById(int productId);

    Product create(Product product);

    Product update(Product product);

    boolean delete(Integer productId);
}

