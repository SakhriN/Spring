package com.example.february16th.service;

import com.example.february16th.model.Comment;
import com.example.february16th.model.Post;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PostService {
    private final Map<UUID, Post> posts;

    public PostService() {
        posts = new HashMap<>();

        Post postA = Post.builder()
                .id(UUID.randomUUID())
                .title("Test 1")
                .description("1er test de fou")
                .content("Bonjour je suis un malade de fou furieux \n" +
                        "tu vois la street c'est la bagarre \n" +
                        "bloup \n")
                .build();

        Post postB = Post.builder()
                .id(UUID.randomUUID())
                .title("Test 2")
                .description("2nd test de fou")
                .content("Bonjour je suis un malade de fou furieux \n" +
                        "tu vois la street c'est la bagarre \n" +
                        "bloup \n")
                .build();

        Post postC = Post.builder()
                .id(UUID.randomUUID())
                .title("Test 3")
                .description("3eme test de fou")
                .content("Bonjour je suis un malade de fou furieux \n" +
                        "tu vois la street c'est la bagarre \n" +
                        "bloup \n")
                .build();

        posts.put(postA.getId(), postA);
        posts.put(postB.getId(), postB);
        posts.put(postC.getId(), postC);
    }

    public List<Post> getPosts() {
        return posts.values().stream().toList();
    }

    public void addPost(Post post) {
        post.setId(UUID.randomUUID());
        posts.put(post.getId(), post);
    }

    public Post getPostById(UUID id) {
        return posts.values().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        //  return rabbits.get(id);
    }

    public Post getPostByTitle(String title) {
        return posts.values().stream().filter(s -> s.getTitle().equals(title)).findFirst().orElse(null);
    }

    public boolean updatePost(UUID id, Post post) {
        boolean test = false;
        Post verification = getPostById(id);
        if (verification != null) {
            post.setId(verification.getId());
            posts.put(post.getId(), post);
            test = true;
        }
        return test;
    }

    public boolean deletePostById(UUID id) {
        boolean test = false;
        if (getPostById(id) != null) {
            posts.remove(id);
            test = true;
        }
        return test;
    }
}

