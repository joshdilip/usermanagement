

package com.harman.usermanagement.service;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.harman.usermanagement.dao.UserDao;
import com.harman.usermanagement.exeption.UserManagementException;
import com.harman.usermanagement.models.User;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(int id) {
        User user = null;
        try {
            user = userDao.get(id);
        } catch (NoSuchElementException e) {
            throw new UserManagementException("User does not exists", HttpStatus.NOT_FOUND.value());
        }
        return user;
    }

    @Override
    public Iterable<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> filterByName(String name) {
        return userDao.filterByUserName(name);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public void deleteById(int id) {
        try {
            userDao.deleteUserById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new UserManagementException("User with id " +id+ " does not exists", HttpStatus.NOT_FOUND.value());
        }
    }

}
