package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Double price;

}
