package net.example.tpcandy.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String title;

    int ranking;

    String content;

    @ManyToOne
    @JoinColumn
    Candy candy;

}
