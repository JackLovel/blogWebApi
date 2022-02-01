package com.example.blogApiz.service;

import com.example.blogApiz.entity.Role;
import com.example.blogApiz.entity.User;

import java.util.List;

public interface UserService {
//    User userService(User user);
//    Role roleService(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
//    User getUser(String username)
    List<User> getUsers();
    User saveUser(User user);
    Role saveRole(Role role);
}
