package net.example.tpcandy.entity;

import jakarta.persistence.*;
import lombok.*;
import net.example.tpcandy.enums.OrdersEnum;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    OrdersEnum status;

    @OneToMany(mappedBy = "orders")
    List<OrderLine> orderLines;


}
