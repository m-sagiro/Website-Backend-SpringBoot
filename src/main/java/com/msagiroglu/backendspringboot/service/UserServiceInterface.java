package com.msagiroglu.backendspringboot.service;

import com.msagiroglu.backendspringboot.model.Role;
import com.msagiroglu.backendspringboot.model.User;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

public interface UserServiceInterface {
    User saveUser(User user);
    User updateUser(User user);
    User findUserById(Long id);
    void deleteUser(Long id);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName) throws RoleNotFoundException;
    User getUser(String username);
    List<User> getUsers();
}