package com.example.it355.controller;


import com.example.it355.entity.Book;
import com.example.it355.entity.User;
import com.example.it355.service.RoleService;
import com.example.it355.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllFromUser(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return ResponseEntity.ok(userService.save(user));
    }


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok(user);
    }
//    @PutMapping
//    public ResponseEntity<User> update(@RequestBody User user){
//        return ResponseEntity.ok(userService.update(user));
//    }


    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Integer userId){
        userService.deleteById(userId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody User userDetails){
        User user = userService.findById(userId);

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());

        User updateUser = userService.save(user);
        return ResponseEntity.ok(updateUser);
    }
}
