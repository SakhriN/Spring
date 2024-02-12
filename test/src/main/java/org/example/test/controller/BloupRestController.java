package org.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/bloup/bipbip")
public class BloupRestController {

    @GetMapping
    public String sayBloup() {
        System.out.println("Bloup");
        return "bloup";
    }

    @GetMapping(value = "bloups")
    public List<String> sayBloup2(){
        return List.of("Canarticho","Metamorph","Aquali");
    }


}
