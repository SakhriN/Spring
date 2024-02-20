package com.example.february16th.controller;


import com.example.february16th.model.Post;
import com.example.february16th.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/demo")
public class DemoRestController {

    private final PostService postService;

    @PostMapping("posts")
    public Post createPost(@RequestBody Post post) {
        post.setId(UUID.randomUUID());
        postService.addPost(post);
        return post;
    }

    @GetMapping("posts")
    public List<Post> getAllPost() {
        return postService.getPosts();
    }

    @GetMapping("post/{id}")
    public Post getOnePost(@PathVariable("id") UUID id) {
        return postService.getPostById(id);
    }

    @PutMapping("post/{id}")
    public boolean UpdatePost(@PathVariable("id") UUID id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("post/{id}")
    public boolean DeletePost(@PathVariable("id") UUID id) {
        return postService.deletePostById(id);
    }

}
