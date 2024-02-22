package net.example.tpcandy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candy {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String name;

    String description;

    String effect;

    double price;

    @OneToMany(mappedBy = "candy")
    List<Review> reviews;

    @OneToMany(mappedBy = "candy")
    List<OrderLine> orderLine;

}
