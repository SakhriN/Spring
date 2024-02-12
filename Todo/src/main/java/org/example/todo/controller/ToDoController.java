package org.example.todo.controller;

import org.example.todo.models.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ToDoController {

    @RequestMapping("/todo")
    public String sayToDo(Model model){
        ToDo toDo = new ToDo("Manger des chips","activité dingue",false);
        model.addAttribute("todo",toDo);
        return "todo";
    }




    @RequestMapping("/todos")
    public String sayToDos(Model model){
        List<ToDo> todos = List.of(new ToDo("Manger des chips","activité dingue",false),
                new ToDo("Manger des kiwi","activité dingue",false),
                new ToDo("Manger des fraises","activité dingue",false),
                new ToDo("Manger des chocolats","activité dingue",false),
                new ToDo("Manger des morts","activité dingue",false),
                new ToDo("Manger des coutteaux","activité dingue",false),
                new ToDo("Manger des frites","activité dingue",false));
        model.addAttribute("todos",todos);
        return "todos";
    }
}
