package com.example.base_spring.controller;


import com.example.base_spring.model.Student;
import com.example.base_spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final StudentService studentService;

    @GetMapping
    public String homePage(){
        return "page_home";
    }

    @GetMapping("/students")
    public String pageb(Model model){
        List<Student> students = studentService.getStudents();
        model.addAttribute("etudiants",students);
        return "page_list";
    }

    @GetMapping("/student/{studentId}")
    public String detailRabbit(@PathVariable("studentId")UUID id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("monetudiant",student);
        return "page_detail";
    }


    @GetMapping("/ajout")
    public String addStudent(Model model){
        model.addAttribute("etudiant",new Student());
        return "form/form";
    }

    @PostMapping("/ajout")
    public String submitStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/regarde")
    public String showRabbit(@RequestParam("firstname") String firstname, Model model){
        Student student = studentService.getStudentByName(firstname);
        model.addAttribute("monetudiant",student);
        return "page_detail";
    }


}
