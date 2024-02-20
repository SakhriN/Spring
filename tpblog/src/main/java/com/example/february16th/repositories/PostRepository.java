package com.example.february16th.repositories;

import com.example.february16th.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface PostRepository extends JpaRepository<Post, UUID> {

public Post findByTitle(String title);
}
