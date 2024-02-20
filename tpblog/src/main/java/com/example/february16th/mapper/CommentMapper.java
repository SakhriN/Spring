package com.example.february16th.mapper;

import com.example.february16th.entity.Comment;
import com.example.february16th.model.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "name", target = "name")
    CommentDTO commentToCommentDto(Comment comment);

    @Mapping(source = "name", target = "name")
    Comment commentDtoToComment(CommentDTO dto);
}
