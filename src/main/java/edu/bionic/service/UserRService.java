package edu.bionic.service;


import edu.bionic.domain.my.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 27.08.17.
 */
public interface UserRService {

    User registerNewUser(User user);

    Optional<User> getAuthenticatedUser();
}

