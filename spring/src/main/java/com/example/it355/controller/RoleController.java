package com.example.it355.controller;


import com.example.it355.entity.Book;
import com.example.it355.entity.Role;
import com.example.it355.service.BookService;
import com.example.it355.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllFromRole(){
        return ResponseEntity.ok(roleService.findAll());
    }

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody Role role){
        return ResponseEntity.ok(roleService.save(role));
    }

    @PutMapping
    public ResponseEntity<Role> update(@RequestBody Role role){
        return ResponseEntity.ok(roleService.update(role));
    }

    @DeleteMapping("/{roleId}")
    public void deleteById(@PathVariable Integer roleId){
        roleService.deleteById(roleId);
    }
}
