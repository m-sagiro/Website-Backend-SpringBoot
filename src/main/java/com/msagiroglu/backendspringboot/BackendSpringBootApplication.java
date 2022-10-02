package com.msagiroglu.backendspringboot;

import com.msagiroglu.backendspringboot.model.Role;
import com.msagiroglu.backendspringboot.model.User;
import com.msagiroglu.backendspringboot.repo.RoleRepo;
import com.msagiroglu.backendspringboot.repo.UserRepo;
import com.msagiroglu.backendspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class BackendSpringBootApplication {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    public static void main(String[] args) {
        SpringApplication.run(BackendSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {

            if (!roleRepo.existsByName("ROLE_USER") && !roleRepo.existsByName("ROLE_ADMIN")) {
                userService.saveRole(new Role(null, "ROLE_USER"));
                userService.saveRole(new Role(null, "ROLE_ADMIN"));
            }

            if (!userRepo.existsByUsername("user1")) {
                userService.saveUser(new User(null, "user1", "user1@user1.com", System.getenv("USER_PASS"), new ArrayList<>()));
                userService.addRoleToUser("user1", "ROLE_USER");
                userService.addRoleToUser("user1", "ROLE_ADMIN");
            }

        };
    }

}
