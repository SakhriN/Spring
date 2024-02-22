package net.example.tpcandy.repository;

import net.example.tpcandy.entity.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "orders", collectionResourceRel = "order")
public interface OrdersRepository extends CrudRepository<Orders, UUID> {
}
