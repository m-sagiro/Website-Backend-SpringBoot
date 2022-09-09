package com.msagiroglu.backendspringboot;

import com.msagiroglu.backendspringboot.model.Role;
import com.msagiroglu.backendspringboot.model.User;
import com.msagiroglu.backendspringboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Slf4j
@SpringBootApplication
public class BackendSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null, "user1", "user1@user1.com", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "user2", "user2@user2.com", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "user3", "user3@user3.com", "12345", new ArrayList<>()));
            userService.saveUser(new User(null, "user4", "user4@user4.com", "12345", new ArrayList<>()));

            userService.addRoleToUser("user1", "ROLE_USER");
            userService.addRoleToUser("user1", "ROLE_ADMIN");
            userService.addRoleToUser("user2", "ROLE_USER");
            userService.addRoleToUser("user3", "ROLE_ADMIN");
            userService.addRoleToUser("user4", "ROLE_ADMIN");

        };
    }

}
