package org.example.todo.controller;

import org.example.todo.models.ToDo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class ToDoRestController {

    @GetMapping(value = "todo")
    public ToDo sayToDo() {
        ToDo toDo = new ToDo("Manger des chips","activité dingue",false);
        return toDo;
    }

    @GetMapping(value = "todos")
    public List<ToDo> sayToDos(){
        List<ToDo> todos = List.of(new ToDo("Manger des chips","activité dingue",false),
                new ToDo("Manger des kiwi","activité dingue",false),
                new ToDo("Manger des fraises","activité dingue",false),
                new ToDo("Manger des chocolats","activité dingue",false),
                new ToDo("Manger des morts","activité dingue",false),
                new ToDo("Manger des coutteaux","activité dingue",false),
                new ToDo("Manger des frites","activité dingue",false));
        return todos;
    }

}
