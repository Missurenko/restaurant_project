package edu.bionic.service;


import edu.bionic.domain.my.User;

import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
public interface UserRService {

    List<User> getAll();

    User getById(int userId);

    User create(User user);

    User update(User user);

    boolean delete(Integer userId);
}

