package com.example.february16th.mapper;


import com.example.february16th.entity.Post;
import com.example.february16th.model.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "title", target = "title")
    PostDTO postToPostDto(Post post);

    @Mapping(source = "title", target = "title")
    Post postDtoToPost(PostDTO dto);
}



