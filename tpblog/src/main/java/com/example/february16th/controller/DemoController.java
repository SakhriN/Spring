package com.example.february16th.controller;


import com.example.february16th.model.CommentDTO;
import com.example.february16th.model.PostDTO;
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


    public DemoController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String homePage() {
        return "page_home";
    }

    @GetMapping("/ajout")
    public String addPost(Model model) {
        model.addAttribute("post", new PostDTO());
        return "form/form";
    }

    @PostMapping("/ajout")
    public String submitPost(@ModelAttribute("post") @Valid PostDTO postDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "form/form";
        }
        PostDTO POST = postService.addPost(postDTO);
        System.out.println(POST);
        return "redirect:/posts";
    }

    @GetMapping("/regarde")
    public String showPost(@RequestParam("title") String title, Model model) {
        PostDTO post = postService.ReadOnePostByTitle(title);
        model.addAttribute("monpost", post);
        return "post_detail";
    }

    @GetMapping("/post/{postId}")
    public String detailPost(@PathVariable("postId") UUID id, Model model) {
        PostDTO post = postService.ReadOnePost(id);
        model.addAttribute("moncomment", new CommentDTO());
        model.addAttribute("monpost", post);
        return "post_detail";
    }
    @PostMapping("/post/{postId}")
    public String AddComment(@PathVariable("postId") UUID id, @ModelAttribute("moncomment") CommentDTO comment) {
        PostDTO post = postService.ReadOnePost(id);
        if (post.getCommentsDTO() == null) {
            post.setCommentsDTO(new ArrayList<>());
        }
        comment.setPostDTO(post);
        CommentDTO commentDTO = postService.addComment(comment);
        post.getCommentsDTO().add(commentDTO);
        commentDTO.setPostDTO(post);
        postService.updatePost(id, post);
        return "redirect:/post/{postId}";
    }

    @GetMapping("/posts")
    public String postRecup(Model model) {
        List<PostDTO> posts = postService.ReadPosts();
        model.addAttribute("posts", posts);
        return "post_list";
    }


    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable("id") UUID id, Model model) {
        PostDTO post = postService.ReadOnePost(id);
        if (post != null) {
            model.addAttribute("post",post);
            return "form/form";
        } else {
            return "/post_list";
        }
    }

    @PostMapping("/edit/{id}")
    public String submitEditPost(@PathVariable("id") UUID id,@Valid @ModelAttribute("post") PostDTO post, BindingResult bindingResult) {
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
