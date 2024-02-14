package com.example.base_spring.controller;


import com.example.base_spring.model.Student;
import com.example.base_spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo")
public class DemoRestController {

    private final StudentService studentService;


    @GetMapping("students")
    public List<Student> getAllStudent(){
        return studentService.getStudents();
    }


}
