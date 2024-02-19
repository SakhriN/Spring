package com.example.demo.service;

import com.example.demo.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();

    Person findById(int id);

    void save(Person person);
    public void update(Person person);

    void deletePersonById(int id);
}
