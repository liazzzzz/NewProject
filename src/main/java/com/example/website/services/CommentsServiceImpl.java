package com.example.website.services;

import com.example.website.models.Comment;
import com.example.website.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public Comment save(Comment comment) {
        return commentsRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentsRepository.deleteCommentById(id) ;
    }

    @Override
    public List<Comment> findCommentByArticle(Long id) {
        return commentsRepository.findCommentByPostId(id);
    }

    @Override
    public Comment findCommentById(Long id) {
        return commentsRepository.findCommentById(id) ;
    }
}
