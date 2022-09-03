package com.msagiroglu.backendspringboot.service;

import com.msagiroglu.backendspringboot.exception.UserNotFoundException;
import com.msagiroglu.backendspringboot.model.CustomUser;
import com.msagiroglu.backendspringboot.repo.CustomUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserService {
    private final CustomUserRepo customUserRepo;

    @Autowired
    public CustomUserService(CustomUserRepo customUserRepo) {
        this.customUserRepo = customUserRepo;
    }

    public CustomUser addCustomUser(CustomUser customUser) {
        return customUserRepo.save(customUser);
    }

    public List<CustomUser> getAllCustomUser() {
        return customUserRepo.findAll();
    }

    public CustomUser updateCustomUser(CustomUser customUser) {
        return customUserRepo.save(customUser);
    }

    public CustomUser findCustomUserById(Long id) {
        return customUserRepo.findCustomUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by Id " + id + " was not found!"));
    }

    public void deleteCustomUser(Long id) {
        customUserRepo.deleteCustomUserById(id);
    }
}
