package com.example.demo.controller;


import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonRestController {

    private PersonService personService;

    @GetMapping("/list")
    public List<Person> getAllPersons(){
        return personService.findAll();
    }

    @GetMapping("person/{id}")
    public Person getOnePerson(@PathVariable int id){
        Person person = personService.findById(id);
        return person;
    }

    @PostMapping("/addoneperson")
    public void addOnePerson(@RequestBody Person person){
personService.save(person);
    }

    @PutMapping("/edit/{id}")
    public void editPerson(@PathVariable int id, @RequestBody Person person){
        personService.update(person);

    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable int id){
        personService.deletePersonById(id);
    }

}
