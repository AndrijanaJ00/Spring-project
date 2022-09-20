package com.example.it355.service;

import com.example.it355.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer userId);

    User save(User user);

    User update(User user);

    void deleteById(Integer userId);
}
