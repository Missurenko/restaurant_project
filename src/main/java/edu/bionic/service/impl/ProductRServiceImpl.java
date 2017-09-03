package edu.bionic.service.impl;


import edu.bionic.dao.ProductRDao;

import edu.bionic.domain.my.Product;

import edu.bionic.service.ProductRService;

import edu.bionic.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
@Service
public class ProductRServiceImpl implements ProductRService {

    private ProductRDao productRDao;

    @Autowired
    public ProductRServiceImpl(ProductRDao productRDao) {
        this.productRDao = productRDao;
    }

    @Override
    public List<Product> getAll() {
        return productRDao.getAll();
    }

    @Override
    public Product getById(int productId) {
        return productRDao.getById(productId).
                orElseThrow(() -> new NotFoundException(String.format("Product this id=%d not found", productId)));
    }

    @Override
    public Product create(Product product) {
        return productRDao.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRDao.save(product);
    }

    @Override
    public boolean delete(Integer productId) {
        return productRDao.delete(productId);
    }

}
