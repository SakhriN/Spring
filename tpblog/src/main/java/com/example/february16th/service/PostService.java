package com.example.february16th.service;

import com.example.february16th.entity.Comment;
import com.example.february16th.entity.Post;
import com.example.february16th.mapper.CommentMapper;
import com.example.february16th.model.CommentDTO;
import com.example.february16th.model.PostDTO;
import com.example.february16th.mapper.PostMapper;
import com.example.february16th.repositories.CommentRepository;
import com.example.february16th.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;


    public PostService(PostRepository postRepository, PostMapper postMapper, CommentRepository commentRepository, CommentMapper commentMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }


    public PostDTO addPost(PostDTO dto) {
//        Post post = postMapper.postDtoToPost(dto);
//        Post savedPost = postRepository.save(post);
//        PostDTO savedDto = postMapper.postToPostDto(savedPost);
//        return savedDto;
        return postMapper.postToPostDto(postRepository.save(postMapper.postDtoToPost(dto)));
    }

    public List<PostDTO> ReadPosts() {
        return postRepository.findAll().stream()
                .map(postMapper::postToPostDto)
                //.map(post -> postMapper.postToPostDto(post))
                .toList();
    }

    public PostDTO ReadOnePost(UUID id) {
        return postMapper.postToPostDto(postRepository.getReferenceById(id));
    }

    public PostDTO ReadOnePostByTitle(String title) {
        return postMapper.postToPostDto(postRepository.findByTitle(title));
    }


    public boolean updatePost(UUID id, PostDTO postDTO) {
        boolean test = false;
        try {
            postRepository.save(postMapper.postDtoToPost(postDTO));
            test = true;

        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
        return test;
    }

    public boolean deletePostById(UUID id) {
        boolean test = false;
        try {
            postRepository.deleteById(id);
            test = true;
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
        return test;
    }

    public CommentDTO addComment(CommentDTO dto) {
        Post post = postMapper.postDtoToPost(dto.getPostDTO());
        Comment comment = commentMapper.commentDtoToComment(dto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDTO savedDto = commentMapper.commentToCommentDto(savedComment);
        return savedDto;
//        return commentMapper.commentToCommentDto(commentRepository.save(commentMapper.commentDtoToComment(dto)));
    }

    public List<CommentDTO> ReadComment() {
        return commentRepository.findAll().stream()
                .map(commentMapper::commentToCommentDto)
                //.map(post -> postMapper.postToPostDto(post))
                .toList();
    }

    public CommentDTO ReadOneComment(UUID id) {
        return commentMapper.commentToCommentDto(commentRepository.getReferenceById(id));
    }

    public CommentDTO ReadOneCommentByName(String name) {
        return commentMapper.commentToCommentDto(commentRepository.findByName(name));
    }


    public boolean updateComment(UUID id, CommentDTO commentDTO) {
        boolean test = false;
        try {
            commentRepository.save(commentMapper.commentDtoToComment(commentDTO));
            test = true;

        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
        return test;
    }

    public boolean deleteCommentById(UUID id) {
        boolean test = false;
        try {
            commentRepository.deleteById(id);
            test = true;
        } catch (Exception ex) {
            ex.fillInStackTrace();
        }
        return test;
    }
}


