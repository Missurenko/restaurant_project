package edu.bionic.dao;


import edu.bionic.domain.my.Product;

import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 27.08.17.
 */
public interface ProductRDao {



    List<Product> getAll();

    Optional<Product> getById(int productId);

    Product save(Product product);

    boolean delete(Integer productId);
}
