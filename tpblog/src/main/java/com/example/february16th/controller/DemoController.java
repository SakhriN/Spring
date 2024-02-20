package com.example.february16th.controller;


import com.example.february16th.model.Comment;
import com.example.february16th.model.Post;
import com.example.february16th.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DemoController {

    private final PostService postService;

    @GetMapping
    public String homePage() {
        return "page_home";
    }

    @GetMapping("/ajout")
    public String addPost(Model model) {
        model.addAttribute("post", new Post());
        return "form/form";
    }

    @PostMapping("/ajout")
    public String submitPost(@ModelAttribute("post") @Valid Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "form/form";
        }
        postService.addPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/regarde")
    public String showPost(@RequestParam("title") String title, Model model) {
        Post post = postService.getPostByTitle(title);
        model.addAttribute("monpost", post);
        return "post_detail";
    }

    @GetMapping("/post/{postId}")
    public String detailPost(@PathVariable("postId") UUID id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("moncomment", new Comment());
        model.addAttribute("monpost", post);
        return "post_detail";
    }
    @PostMapping("/post/{postId}")
    public String AddComment(@PathVariable("postId") UUID id, @ModelAttribute("moncomment")Comment comment) {
        Post post = postService.getPostById(id);
        if (post.getComments() == null) {
            post.setComments(new ArrayList<>());
        }
        comment.setId(UUID.randomUUID());
        comment.setPost(post);
        post.getComments().add(comment);
        postService.updatePost(id, post);
        return "redirect:/post/{postId}";
    }

    @GetMapping("/posts")
    public String postb(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "post_list";
    }


    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable("id") UUID id, Model model) {
        Post post = postService.getPostById(id);
        if (post != null) {
            model.addAttribute("post",post);
            return "form/form";
        } else {
            return "/post_list";
        }
    }

    @PostMapping("/edit/{id}")
    public String submitEditPost(@PathVariable("id") UUID id,@Valid @ModelAttribute("post") Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "form/form";
        }
        postService.updatePost(id, post);
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") UUID id) {
        postService.deletePostById(id);
        return "redirect:/posts";
    }
}
