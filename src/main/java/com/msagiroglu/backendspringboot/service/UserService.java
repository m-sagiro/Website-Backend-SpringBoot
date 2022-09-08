package com.msagiroglu.backendspringboot.service;

import com.msagiroglu.backendspringboot.exception.UserNotFoundException;
import com.msagiroglu.backendspringboot.model.Role;
import com.msagiroglu.backendspringboot.model.User;
import com.msagiroglu.backendspringboot.repo.RoleRepo;
import com.msagiroglu.backendspringboot.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements UserServiceInterface{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to db", user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        log.info("Updating user {} in db", user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Deleting user {} from db", id);
        userRepo.deleteUserById(id);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepo.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not ound!"));
    }

    @Override
    public User findUserById(Long id) {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by Id " + id + " was not found!"));
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role{}", role);
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) throws RoleNotFoundException {
        log.info("Adding role {} to user {}", roleName, username);
        User user = userRepo.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User not ound!"));
        Role role = roleRepo.findByName(roleName).orElseThrow(() -> new RoleNotFoundException("Role not found!"));
        user.getRoles().add(role);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
