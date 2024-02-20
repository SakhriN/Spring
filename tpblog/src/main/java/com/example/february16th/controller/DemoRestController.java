package com.example.february16th.controller;


import com.example.february16th.entity.Post;
import com.example.february16th.model.PostDTO;
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

    public DemoRestController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("posts")
    public PostDTO createPost(@RequestBody PostDTO post) {
        post.setId(UUID.randomUUID());
        postService.addPost(post);
        return post;
    }

    @GetMapping("posts")
    public List<PostDTO> getAllPost() {
        return postService.ReadPosts();
    }

    @GetMapping("post/{id}")
    public PostDTO getOnePost(@PathVariable("id") UUID id) {
        return postService.ReadOnePost(id);
    }

    @PutMapping("post/{id}")
    public boolean UpdatePost(@PathVariable("id") UUID id, @RequestBody PostDTO post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("post/{id}")
    public boolean DeletePost(@PathVariable("id") UUID id) {
        return postService.deletePostById(id);
    }

}
