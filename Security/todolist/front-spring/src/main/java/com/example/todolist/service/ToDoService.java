package com.example.todolist.service;

import com.example.todolist.entity.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> findAll();

    ToDo findById(int id);

    void save(ToDo product);
    public void update(ToDo product);

    void deleteToDoById(int id);
}
