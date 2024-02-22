package com.example.february16th.repositories;

import com.example.february16th.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    public List<Comment> findAllByPostId(UUID id);

    public Comment findByName(String name);

}
