package com.example.it355.service;

import com.example.it355.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById(Integer roleId);

    Role save(Role role);

    Role update(Role role);

    void deleteById(Integer roleId);
}
