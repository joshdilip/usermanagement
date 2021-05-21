

package com.harman.usermanagement.service;


import java.util.List;

import com.harman.usermanagement.models.User;


public interface UserService {
    User getById(int id);
    Iterable<User> getAll();
    List<User> filterByName(String name);
    User save(User user);
    User findByEmail(String email);
    void deleteById(int id);
}
