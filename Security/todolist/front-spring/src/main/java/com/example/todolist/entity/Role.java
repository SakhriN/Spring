package com.example.todolist.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @OneToMany(mappedBy = "role")
    List<User> users;
}
