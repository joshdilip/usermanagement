package com.harman.usermanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.harman.usermanagement.models.User;

public interface UserDataJpa extends CrudRepository<User, Integer>{

    User findByEmail(String email);
    
    @Query("SELECT firstname from User user WHERE user.firstname LIKE CONCAT('%',:firstname,'%') ")
    List<User> filterByUsername(@Param("firstname") String firstname);
    
    void deleteById(int id);
   
}
