package edu.bionic.service;


import edu.bionic.domain.Order;
import edu.bionic.domain.my.Checks;
import edu.bionic.domain.my.Material;


import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
public interface CheckService {

    List<Checks> getAll();

    Checks getById(int checksId);

    void addProductToCheck(Checks currentCheck, Integer productId);

    void createNewCheck(Checks check);



    void removeProductFromCheck(Checks currentCheck, Integer index);

    List<Checks> getAllByAuthUser();
}

