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
    public String homePage() {
        return "page_home";
    }

    @GetMapping("/ajout")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "form/form";
    }

    @PostMapping("/ajout")
    public String submitStudent(@ModelAttribute("student") Student student) {
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/regarde")
    public String showStudent(@RequestParam("firstname") String firstname, Model model) {
        Student student = studentService.getStudentByName(firstname);
        model.addAttribute("monetudiant", student);
        return "page_detail";
    }

    @GetMapping("/student/{studentId}")
    public String detailStudent(@PathVariable("studentId") UUID id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("monetudiant", student);
        return "page_detail";
    }

    @GetMapping("/students")
    public String pageb(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("etudiants", students);
        return "page_list";
    }


    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") UUID id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student",student);
            return "form/form";
        } else {
            return "/page_list";
        }
    }

    @PostMapping("/edit/{id}")
    public String submitEditStudent(@PathVariable("id") UUID id,@ModelAttribute("student") Student student) {
        studentService.updateStudent(id, student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") UUID id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
