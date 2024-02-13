package com.example.base_spring.controller;


import com.example.base_spring.model.Rabbit;
import com.example.base_spring.service.RabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final RabbitService rabbitService;

    @GetMapping
    public String homePage(){
        return "pagea";
    }

    @GetMapping("/rabbits")
    public String pageb(Model model){
        List<Rabbit> rabbits = rabbitService.getRabbits();
        model.addAttribute("lapins",rabbits);
        return "page_list";
    }

    @GetMapping("/rabbit/{rabbitId}")
    public String detailRabbit(@PathVariable("rabbitId")UUID id, Model model){
        Rabbit rabbit = rabbitService.getRabbitById(id);
        model.addAttribute("monlapin",rabbit);
        return "page_detail";
    }


    @GetMapping("/ajout")
    public String addRabbit(Model model){
        model.addAttribute("lapin",new Rabbit());
        return "form/form";
    }

    @PostMapping("/ajout")
    public String submitRabbit(@ModelAttribute("rabbit") Rabbit rabbit){
        rabbitService.addRabbit(rabbit);
        return "redirect:/rabbits";
    }

    @GetMapping("/regarde/{name}")
    public String showRabbit(@RequestParam("name") String name, Model model){
        Rabbit rabbit = rabbitService.getRabbitByName(name);
        model.addAttribute(rabbit);
        return "page_detail";
    }


}
