package com.harman.usermanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.harman.usermanagement.models.User;

@Repository
public class UserDaoImpl implements UserDao {
    
    @Autowired
    private UserDataJpa repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User get(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Iterable<User> getAll() {
        return repository.findAll();
    }

    @Override
    public List<User> filterByUserName(String name) {
        return repository.filterByUsername(name);
    }

    @Override
    public User findByEmail(String email) {
       return repository.findByEmail(email);
    }

    @Override
    public void deleteUserById(int id) {
         repository.deleteById(id);
    }
    
    
}
