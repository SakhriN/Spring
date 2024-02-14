package com.example.base_spring.service;

import com.example.base_spring.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class StudentService {
    private final Map<UUID, Student> students;

    public StudentService(){
        students = new HashMap<>();

        Student studentA = Student.builder()
                .id(UUID.randomUUID())
                .firstname("Nassim")
                .lastname("Sakhri")
                .email("nassims97@hotmail.fr")
                .age(26)
                .build();

        Student studentB = Student.builder()
                .id(UUID.randomUUID())
                .firstname("Clement")
                .lastname("Roelens")
                .email("clement@roelens.fr")
                .age(26)
                .build();

        Student studentC = Student.builder()
                .id(UUID.randomUUID())
                .firstname("Christophe")
                .lastname("Delory")
                .email("toto@tata.fr")
                .age(123456789)
                .build();

        students.put(studentA.getId(),studentA);
        students.put(studentB.getId(),studentB);
        students.put(studentC.getId(),studentC);
    }

    public List<Student> getStudents(){
        return students.values().stream().toList();
    }

    public Student getStudentById(UUID id){
        return students.values().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
      //  return rabbits.get(id);
    }

    public void addStudent(Student student){
        student.setId(UUID.randomUUID());
        students.put(student.getId(),student);
    }

    public Student getStudentByName(String firstname) {
        return students.values().stream().filter(s -> s.getFirstname().equals(firstname)).findFirst().orElse(null);
    }
}
