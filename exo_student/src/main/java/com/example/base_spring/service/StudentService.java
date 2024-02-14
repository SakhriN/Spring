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

    public StudentService() {
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

        students.put(studentA.getId(), studentA);
        students.put(studentB.getId(), studentB);
        students.put(studentC.getId(), studentC);
    }

    public List<Student> getStudents() {
        return students.values().stream().toList();
    }

    public void addStudent(Student student) {
        student.setId(UUID.randomUUID());
        students.put(student.getId(), student);
    }

    public Student getStudentById(UUID id) {
        return students.values().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        //  return rabbits.get(id);
    }

    public Student getStudentByName(String firstname) {
        return students.values().stream().filter(s -> s.getFirstname().equals(firstname)).findFirst().orElse(null);
    }

    public boolean updateStudent(UUID id, Student student) {
        boolean test = false;
        Student verification = getStudentById(id);
        if (verification != null) {
            student.setId(verification.getId());
            students.put(student.getId(), student);
            test = true;
        }
        return test;
    }

    public boolean deleteStudentById(UUID id) {
        boolean test = false;
        if (getStudentById(id) != null) {
            students.remove(id);
            test = true;
        }
        return test;
    }
}
