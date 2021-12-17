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

//    @GetMapping("/deleteComment/{id}")
//    public String getComments(@PathVariable(name="id") Long id){
//        Comment comment = commentsService.findCommentById(id);
//        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
//        Optional<User> optionalUser = usersService.findUserByEmail(auth);
//        if (optionalUser.isPresent()){
//            User user = optionalUser.get();
//            if (comment.getUser().equals(user)) {
//                commentsService.deleteCommentById(id);
//                return "redirect:/posts/";
//            } else {
//                return "error";
//            }
//        } else {
//            return "error";
//        }
//    }

    @PostMapping("/posts/{id}/comment")
    public String createComment(@PathVariable Long id, Comment commentForm){
        Article post = (articlesService.getById(id)).get();
        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = usersService.findUserByEmail(auth);
        Comment newComment = new Comment();
        newComment.setText(commentForm.getText());
        if(optionalUser.isPresent()) {
            newComment.setUser(optionalUser.get());
            newComment.setPost(post);
            newComment.setCreatedAt(LocalDateTime.now());
            commentsService.save(newComment);
            return "redirect:/posts/{id}";
        } else {
            return "error";
        }
    }

}
