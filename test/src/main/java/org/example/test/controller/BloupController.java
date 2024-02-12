package org.example.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BloupController {

    @RequestMapping(value = "/")
    @GetMapping
    public String sayBloup() {
        System.out.println("Bloup");
        return "bloup";
    }


    @RequestMapping("/distorsion")
    public String sayDistorsion(Model model){
        List<String> persons = List.of("JON","JAN","JEAN","JOUNE");
        model.addAttribute("firstname", "Nassim");
        model.addAttribute("lastname", "Sakhri");
        model.addAttribute("persons",persons);
        return "person/details";
    }
}
