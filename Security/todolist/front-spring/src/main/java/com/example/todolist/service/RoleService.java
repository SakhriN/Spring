package com.example.todolist.service;

import com.example.todolist.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById(int id);

    void save(Role product);
    public void update(Role product);

    void deleteRoleById(int id);
}
