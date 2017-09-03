package edu.bionic.service.impl;

import edu.bionic.dao.MaterialDao;
import edu.bionic.dao.UserRDao;
import edu.bionic.domain.my.Material;
import edu.bionic.domain.my.User;
import edu.bionic.service.MaterialService;
import edu.bionic.service.UserRService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bm on 27.08.17.
 */
@Service
public class UserRServiceImpl implements UserRService {

    private UserRDao userRDao;

    @Autowired
    public UserRServiceImpl(UserRDao userRDao) {
        this.userRDao = userRDao;
    }


    @Override
    public List<User> getAll() {
        return userRDao.getAll();
    }

    @Override
    public User getById(int userId) {
        return userRDao.getById(userId).
                orElseThrow(() -> new NotFoundException(String.format("User this id=%d not found", userId)));
    }

    @Override
    public User create(User user) {
        return userRDao.save(user);
    }

    @Override
    public User update(User user) {
        return userRDao.save(user);
    }

    @Override
    public boolean delete(Integer userId) {
        return userRDao.delete(userId);
    }

}
