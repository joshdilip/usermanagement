package com.harman.usermanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.harman.usermanagement.models.User;


@Repository
public interface UserDao {
    User save(User user);

    User get(int id);

    Iterable<User> getAll();

    List<User> filterByUserName(String name);

    User findByEmail(String email);
    
    void deleteUserById(int id);
}
