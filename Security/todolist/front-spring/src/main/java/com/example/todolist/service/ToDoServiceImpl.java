package com.example.todolist.service;

import com.example.todolist.entity.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todolist.repository.ToDoRepository;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {

    private ToDoRepository todoRepository;

    @Autowired
    public ToDoServiceImpl(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<ToDo> findAll() {

        return todoRepository.findAll();
    }

    @Override
    public ToDo findById(int id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public void save(ToDo todo) {
        todoRepository.save(todo);
    }

    public void update(ToDo todo) {
        todoRepository.save(todo);
    }


    @Override
    public void deleteToDoById(int id) {
        todoRepository.deleteById(id);
    }
}