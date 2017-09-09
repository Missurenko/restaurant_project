package edu.bionic.service.impl;

import edu.bionic.dao.ChecksDao;

import edu.bionic.domain.my.User;
import edu.bionic.domain.my.Checks;
import edu.bionic.domain.my.Product;
import edu.bionic.service.CheckService;
import edu.bionic.service.ProductRService;
import edu.bionic.service.UserRService;
import edu.bionic.util.exception.AccessDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
@Service
public class CheckServiceImpl implements CheckService {

    private ChecksDao checksDao;

    private ProductRService productRService;

    private UserRService rService;


    @Autowired
    public CheckServiceImpl(ChecksDao checksDao, ProductRService productRService, UserRService rService) {
        this.checksDao = checksDao;

        this.productRService = productRService;
        this.rService = rService;
    }


    @Override
    public List<Checks> getAll() {
        return checksDao.getAll();
    }

    @Override
    public Checks getById(int checksId) {
        return null;
    }

    @Override
    public void createNewCheck(Checks check) {
        check.setDateTime(LocalDateTime.now());
        check.setUser(rService.getAuthenticatedUser().orElse(null));
        checksDao.save(check);
    }

    @Override
    public void removeProductFromCheck(Checks currentCheck, Integer index) {
        currentCheck.removeProduct(index);
    }

    @Override
    public List<Checks> getAllByAuthUser() {
        User authUser = rService.getAuthenticatedUser()
                .orElseThrow(() -> new AccessDeniedException("User are not authorized"));

        return checksDao.getAllByUser(authUser.getId());
    }

    @Override
    public void addProductToCheck(Checks checks, Integer productId) {
        Product newProduct = productRService.getById(productId);
        checks.addProduct(newProduct);
        checks.setSumma(
                checks.getProductList()
                        .stream()
                        .map(edu.bionic.domain.my.Product::getPriceForSale)
                        .reduce(BigDecimal::add)
                        .orElse(BigDecimal.ZERO)
        );
    }



}
