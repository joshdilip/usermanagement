

package com.harman.usermanagement.controller;


import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.harman.usermanagement.exeption.UserManagementException;
import com.harman.usermanagement.models.User;
import com.harman.usermanagement.service.UserService;


@SpringBootTest
class UserControllerTest {

    @Autowired
    private UserController userController;

    @Mock
    private UserService userService;
    
    @Before
    public void setUp() {
        Mockito.mock(UserControllerTest.class);
    }

    @Test
    public void createUserTest() {
        when(userService.save(any())).thenReturn(newUser());
        ResponseEntity<?> userResponse = userController.createUser(newUser());
        assertNotNull(userResponse);
    }
    
    @Test
    public void getUser() {
        when(userService.getById(anyInt())).thenReturn(newUser());
        ResponseEntity<?> userResponse = userController.getUser(4);
        assertNotNull(userResponse);
    }

    @Test
    public void getAllUsersTest() {
        when(userService.getAll()).thenReturn(new ArrayList<>());
        ResponseEntity<?> userResponse = userController.getAllUsers();
        assertNotNull(userResponse);
    }

    @Test
    public void deleteUser() {
        doNothing().when(userService).deleteById(anyInt());
        Assertions.assertThrows(UserManagementException.class, () -> {
            userController.deleteUser(1);
          });
    }
    public User newUser() {
        return new User("Dilip", "Joshi", "dilip@gmail.com");
    }

}
