package net.example.tpcandy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    int quantity;

    @ManyToOne
    @JoinColumn(name = "candy_id")
    Candy candy;

    @ManyToOne
    @JoinColumn
    Orders orders;


}
