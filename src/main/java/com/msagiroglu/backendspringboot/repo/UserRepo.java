package com.msagiroglu.backendspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.msagiroglu.backendspringboot.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    void deleteUserById(Long id);
    Optional<User> findUserById(Long id);
    Optional<User> findByUsername(String username);
}
