package edu.bionic.service;


import edu.bionic.domain.my.Category;
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

    int getCount(Category categoty, String name);

    List<Product> getAll(Category categoty, String name, int offset, int limit);
}

