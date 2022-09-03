package com.msagiroglu.backendspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.msagiroglu.backendspringboot.model.CustomUser;

import java.util.Optional;

public interface CustomUserRepo extends JpaRepository<CustomUser, Long> {
    void deleteCustomUserById(Long id);

    Optional<CustomUser> findCustomUserById(Long id);
}
