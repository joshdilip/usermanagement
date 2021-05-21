package com.harman.usermanagement.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harman.usermanagement.models.User;
import com.harman.usermanagement.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usermanagement/api/v1")
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody User userRequest) {
        if(null != userService.findByEmail(userRequest.getEmail())) {
            return ResponseEntity.ok("User exists");
        }
        return ResponseEntity.ok(userService.save(userRequest));
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<?>  getUser(@PathVariable int id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/users")
    public ResponseEntity<?>  getAllUsers() {
        Iterable<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }
    
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?>  deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User with id "+id+ " deleted");
    }

}
