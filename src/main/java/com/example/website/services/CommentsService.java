package com.example.website.services;

import com.example.website.models.Comment;

import java.util.List;

public interface CommentsService {

    Comment save(Comment comment);

    void deleteCommentById(Long id);

    List<Comment> findCommentByArticle(Long id);

    Comment findCommentById(Long id);

}
