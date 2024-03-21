package com.example.todolist.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;

    String description;

    boolean status;

}
