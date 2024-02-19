package com.example.base_spring.controller;


import com.example.base_spring.model.Student;
import com.example.base_spring.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo")
public class DemoRestController {

    private final StudentService studentService;

    @PostMapping("students")
    public Student createStudent(@RequestBody @Valid Student student, BindingResult bindingResult) {
        student.setId(UUID.randomUUID());
        studentService.addStudent(student);
        return student;
    }

    @GetMapping("students")
    public List<Student> getAllStudent() {
        return studentService.getStudents();
    }

    @GetMapping("student/{id}")
    public Student getOneStudent(@PathVariable("id") UUID id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("student/{id}")
    public boolean UpdateStudent(@PathVariable("id") UUID id, @Valid @RequestBody Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){

        }
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("student/{id}")
    public boolean DeleteStudent(@PathVariable("id") UUID id) {
        return studentService.deleteStudentById(id);
    }

}
