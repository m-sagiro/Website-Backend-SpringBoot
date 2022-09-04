package com.msagiroglu.backendspringboot;

import com.msagiroglu.backendspringboot.model.CustomUser;
import com.msagiroglu.backendspringboot.service.CustomUserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class CustomUserController {
    private final CustomUserService customUserService;

    public CustomUserController(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomUser>> getAllCustomUser() {
        List<CustomUser> customUsers = customUserService.getAllCustomUser();
        return new ResponseEntity<>(customUsers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CustomUser> getCustomUserById(@PathVariable("id") Long id) {
        CustomUser customUser = customUserService.findCustomUserById(id);
        return new ResponseEntity<>(customUser, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CustomUser> addCustomUser(@RequestBody CustomUser customUser) {
        CustomUser newCustomUser = customUserService.addCustomUser(customUser);
        return new ResponseEntity<>(newCustomUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomUser> updateCustomUser(@RequestBody CustomUser customUser) {
        CustomUser updatedCustomUser = customUserService.updateCustomUser(customUser);
        return new ResponseEntity<>(updatedCustomUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomUser> updateCustomUser(@PathVariable("id") Long id) {
        customUserService.deleteCustomUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
