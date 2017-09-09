package edu.bionic.dao;


import edu.bionic.domain.my.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 27.08.17.
 */
public interface UserRDao {

    List<User> getAll();

    Optional<User> getById(int userId);

    User save(User user);

    boolean delete(Integer userId);

    Optional<User> getByEmail(String username);
}
