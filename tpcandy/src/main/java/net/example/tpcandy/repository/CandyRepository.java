package net.example.tpcandy.repository;

import net.example.tpcandy.entity.Candy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;
@RepositoryRestResource(path = "candies", collectionResourceRel = "candy")
public interface CandyRepository extends CrudRepository<Candy, UUID> {

    public Candy findByName(String name);

    public Candy findByEffect(String effect);

    public Candy findByPrice(double price);

}
