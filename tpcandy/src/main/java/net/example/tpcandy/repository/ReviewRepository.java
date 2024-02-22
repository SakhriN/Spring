package net.example.tpcandy.repository;

import net.example.tpcandy.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "reviews", collectionResourceRel = "review")
public interface ReviewRepository extends CrudRepository<Review, UUID> {
}
