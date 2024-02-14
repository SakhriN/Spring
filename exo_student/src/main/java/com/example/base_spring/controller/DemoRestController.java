package com.example.base_spring.controller;


import com.example.base_spring.model.Student;
import com.example.base_spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo")
public class DemoRestController {

    private final StudentService studentService;

    @PostMapping("students")
    public Student createStudent(@RequestBody Student student) {
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
    public boolean UpdateStudent(@PathVariable("id") UUID id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("student/{id}")
    public boolean DeleteStudent(@PathVariable("id") UUID id) {
        return studentService.deleteStudentById(id);
    }

}
