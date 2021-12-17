package com.example.website.controllers;

import com.example.website.models.Comment;
import com.example.website.models.Article;
import com.example.website.models.User;
import com.example.website.services.CommentsService;
import com.example.website.services.ArticlesService;
import com.example.website.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class CommentController {

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private ArticlesService articlesService;

    @PostMapping("/articles/{id}/comment")
    public String createComment(@PathVariable Long id, Comment commentForm){
        Article article = (articlesService.getById(id)).get();
        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = usersService.findUserByEmail(auth);
        Comment newComment = new Comment();
        newComment.setText(commentForm.getText());
        if(optionalUser.isPresent()) {
            newComment.setUser(optionalUser.get());
            newComment.setArticle(article);
            newComment.setCreatedAt(LocalDateTime.now());
            commentsService.save(newComment);
            return "redirect:/articles/{id}";
        } else {
            return "error";
        }
    }

}
