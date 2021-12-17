package com.example.website.repositories;

import com.example.website.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
     List<Comment> findCommentByArticleId(Long id);

     Comment findCommentById(Long id);

     void deleteCommentById(Long id);

}
