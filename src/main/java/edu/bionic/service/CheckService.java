package edu.bionic.service;


import edu.bionic.domain.my.Checks;
import edu.bionic.domain.my.Material;


import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
public interface CheckService {

    List<Checks> getAll();

    Checks getById(int checksId);

    Checks create(Checks checks);

    Checks update(Checks checks);

    boolean delete(Integer checksId);
}

